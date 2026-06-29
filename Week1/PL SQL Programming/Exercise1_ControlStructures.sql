SET SERVEROUTPUT ON;

ALTER TABLE Customers ADD IsVIP CHAR(1);

DECLARE
    v_age NUMBER;
BEGIN
    FOR c IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;
END;
/
