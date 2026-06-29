SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_trans IS
        SELECT TransactionID, Amount
        FROM Transactions
        WHERE TRUNC(TransactionDate,'MM') = TRUNC(SYSDATE,'MM');
    v_id Transactions.TransactionID%TYPE;
    v_amt Transactions.Amount%TYPE;
BEGIN
    OPEN c_trans;
    LOOP
        FETCH c_trans INTO v_id, v_amt;
        EXIT WHEN c_trans%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Transaction: '||v_id||' Amount: '||v_amt);
    END LOOP;
    CLOSE c_trans;
END;
/
