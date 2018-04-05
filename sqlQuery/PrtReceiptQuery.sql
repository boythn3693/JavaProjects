SELECT
     CASE WHEN r."Status"=1THEN 'Thanh Cong'WHEN r."Status"=2THEN 'Da Huy'ELSE 'UNKWON'END AS "Trang_Thai",
     r."ReceiptId" AS Ma_Phieu,
     r."Datetime" AS Ngay,
     p."PartnerName" AS Doi_Tac,
     rd."Quantity" AS So_Luong,
     pro."ProductName" AS San_Pham
FROM
     "receipt" r INNER JOIN "partner" p ON r."PartnerId" = p."PartnerId"
     INNER JOIN "receiptdetail" rd ON r."ReceiptId" = rd."ReceiptId"
     INNER JOIN "product" pro ON rd."ProductId" = pro."ProductId"
WHERE r.status = 1