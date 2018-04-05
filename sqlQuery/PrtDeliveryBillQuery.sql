SELECT
     CASE WHEN r."Status"=1THEN 'Thanh Cong'WHEN r."Status"=2THEN 'Da Huy'ELSE 'UNKWON'END AS "Trang_Thai",
     r."deliverybillId" AS Ma_Phieu,
     r."Datetime" AS Ngay,
     p."PartnerName" AS Doi_Tac,
     rd."Quantity" AS So_Luong,
     pro."ProductName" AS San_Pham
FROM
     "deliverybill" r INNER JOIN "partner" p ON r."PartnerId" = p."PartnerId"
     INNER JOIN "deliverybilldetail" rd ON r."deliverybillId" = rd."deliverybillId"
     INNER JOIN "product" pro ON rd."ProductId" = pro."ProductId"
WHERE r.Status = 1