BEGIN
    FOR cust IN (
        SELECT c.CustomerID, l.LoanID
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB)/12 > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = cust.LoanID;

        DBMS_OUTPUT.PUT_LINE('1% Discount Applied to Customer ID: ' || cust.CustomerID);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD IsVIP VARCHAR2(5)';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE = -01430 THEN
            NULL; -- Column already exists
        ELSE
            RAISE;
        END IF;
END;
/

BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' || loan_rec.LoanID ||
            ' for ' || loan_rec.Name ||
            ' is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD')
        );
    END LOOP;
END;
/

-- Check VIP status
SELECT CustomerID, Name, IsVIP FROM Customers;

-- Check updated interest rates
SELECT * FROM Loans;

-- View all upcoming reminders
SELECT * FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;


UPDATE Customers
SET Balance = 15000
WHERE CustomerID = 2;

COMMIT;

BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust.CustomerID;

        DBMS_OUTPUT.PUT_LINE('VIP Assigned to Customer ID: ' || cust.CustomerID);
    END LOOP;

    COMMIT;
END;
/