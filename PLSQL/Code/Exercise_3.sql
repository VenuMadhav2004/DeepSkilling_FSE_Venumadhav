CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_count NUMBER := 0;
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    v_count := SQL%ROWCOUNT;

    DBMS_OUTPUT.PUT_LINE('Savings accounts updated: ' || v_count);
END;
/

SET SERVEROUTPUT ON;
BEGIN
    ProcessMonthlyInterest;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
) IS
    v_count NUMBER := 0;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    v_count := SQL%ROWCOUNT;

    DBMS_OUTPUT.PUT_LINE('Employees updated in department ' || p_Department || ': ' || v_count);
END;
/
SET SERVEROUTPUT ON;

BEGIN
    UpdateEmployeeBonus('IT', 10);  -- 10% bonus to IT department
END;
/

CREATE SEQUENCE Transaction_Seq START WITH 3 INCREMENT BY 1;
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccountID IN NUMBER,
    p_ToAccountID IN NUMBER,
    p_Amount IN NUMBER
) IS
    v_FromBalance NUMBER;
BEGIN
    -- Fetch balance of source account
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    -- Check for sufficient funds
    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_FromAccountID;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_ToAccountID;

    -- Log debit transaction
    INSERT INTO Transactions (
        TransactionID, AccountID, TransactionDate, Amount, TransactionType
    ) VALUES (
        Transaction_Seq.NEXTVAL, p_FromAccountID, SYSDATE, p_Amount, 'TransferOut'
    );

    -- Log credit transaction
    INSERT INTO Transactions (
        TransactionID, AccountID, TransactionDate, Amount, TransactionType
    ) VALUES (
        Transaction_Seq.NEXTVAL, p_ToAccountID, SYSDATE, p_Amount, 'TransferIn'
    );

    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_Amount || ' transferred from Account ' || p_FromAccountID || ' to Account ' || p_ToAccountID);
END;
/

ALTER TABLE Transactions
MODIFY TransactionType VARCHAR2(15);

SET SERVEROUTPUT ON;

BEGIN
    TransferFunds(2, 1, 500);  -- Transfer ₹500 from Account 2 to Account 1
END;
/



