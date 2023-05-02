insert into persona values (1, "calarca", "12345", "casa #12", "juan", 0, "123456");
insert into persona values (2, "calarca", "1234", "casa #12", "carlos", 0, "123456");
insert into persona values (3, "calarca", "123", "casa #12", "pablo", 1, "123456");
insert into persona values (4, "calarca", "12", "casa #12", "juancho", 0, "123456");

insert into departamento values (1, "quindio");
insert into departamento values (2, "caldas");
insert into departamento values (3, "risaralda");
insert into departamento values (4, "huila");


insert into municipio values (1, "calarca", 1);
insert into municipio values (2, "manizales", 2);
insert into municipio values (3, "pereira", 3);
insert into municipio values (4, "neiva", 4);
insert into municipio values (5, "gigante", 4);
insert into municipio values (6, "armenia", 1);


insert into  proveedor values (1, "12345", "SI", 1600, "asoMoras", 2, 2500, 3000, 4, 4);
insert into  proveedor values (2, "123", "NO", 1500, "finca el narciso", 4, 2500, 2500, 3, 3);
insert into  proveedor values (3, "12", "SI", 1600, "cofiMoras", 1, 1100, 1100, 4, 4);


insert into categoria values (1, "canastilla de mora", 6, "arreglada", "kilos");
insert into categoria values (2, "mora sin clasificar", 6, "rama", "kilos");
insert into categoria values (3, "mora en proceso de refirgeracion", 20, "refirgerada", "kilos");
insert into categoria values (4, "pulpa de mora", 15, "pulpa", "kilos");

insert into producto values (1, 100, "mora en canastillas tipo arreglada", 100, '09/04/2023', '15/04/2023', "canastilla de mora arreglada", 6000, 10000, 1, 1);
insert into producto values (2, 100, "mora en canastillas tipo rama", 60, '09/04/2023', '13/04/2023', "canastilla de mora rama", 5000, 10000, 2, 1);
insert into producto values (3, 60, "mora en pulpa", 60, '10/04/2023', '25/04/2023', "pulpa de mora", 7000, 15000, 3, 1);





insert into  punto_venta values (1, 5000, "donMora", 1, 1);
insert into  punto_venta values (2, 4500, "donMorita", 2, 2);
insert into  punto_venta values (3, 5000, "donMorales", 1, 1);
insert into  punto_venta values (4, 5000, "seremca", 4, 3);


insert into  venta values (1, '12/04/2023', 60000, 1);
insert into  venta values (2, '20/04/2023', 120000, 2);
insert into  venta values (3, '16/04/2023', 60000, 3);

insert into detalle_venta values (1, 4, 0, 60000, 2, 1);
insert into detalle_venta values (2, 12, 0, 120000, 1, 2);
insert into detalle_venta values (3, 10, 40, 60000, 1, 3);


insert into estado values (1, "pedido recibido", "Recibido");
insert into estado values (2, "pedido despachado", "Despachado");
insert into estado values (3, "pedido entregado", "entregado");


insert into envio values (1, "calle 123#12-3", '16/04/2023', 3, "123", 2, 3, 1);
insert into envio values (2, "calle 123#12-3", '20/04/2023', 2, "123", 3, 2, 1);
insert into envio values (3, "calle 123#12-3", '12/04/2023', 1, "123", 2, 1, 1);
