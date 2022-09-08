-- insert para tabla de formatos
INSERT
INTO
  formatos
  ( tipo)
VALUES
  ('500ml'),
  ('750ml'),
  ('1.5l'),
  ('2.25l'),
  ('3l');
-- insert para tabla de marcas
INSERT
INTO
  marcas
  (nombre, enlace)
VALUES
    ('Talca', 'https://scontent.fluq3-1.fna.fbcdn.net/v/t1.6435-9/57451118_1960636304062775_8817114632264089600_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeFX3b88mrZROEanr65g08Tb5eB9NMDt9mbl4H00wO32Zt6slqElyC3fdGGiTB6Vfkx8TM3p5wKNWGN1O2r1ryMF&_nc_ohc=3x_-FCdPfd4AX-K2g46&tn=iDZ978rNQQka_R1T&_nc_ht=scontent.fluq3-1.fna&oh=00_AT_R5-H0bz0B3gVVmjcw2LzyqTJzw9gL4GrFF7A4gV7vMg&oe=633B0A75'),
    ('Imperial', 'https://scontent.fluq3-1.fna.fbcdn.net/v/t39.30808-6/292291000_5352311628149529_6536240906962974119_n.jpg?_nc_cat=1&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeHlv3H2Uz5WLMdRuL0_-y2v7nL-cgQ2klzucv5yBDaSXLHI5Ma4t4lPClLJaWrlVYl_ldOxiM9fWmM0FVcVn4AC&_nc_ohc=mOmsB3DUgMAAX8tQyYS&_nc_ht=scontent.fluq3-1.fna&oh=00_AT8JBjB-ky7_fJss8_oGdD-_AGXi0ZxD9kmTBNvzok5QTw&oe=631A47E6'),
    ('Heineken', 'https://scontent.fluq3-1.fna.fbcdn.net/v/t1.6435-9/37568671_1859067904113633_1881463312240082944_n.jpg?_nc_cat=1&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeHhpIpkUM-tMTXjisSGIIXQOvgd6CdTH5A6-B3oJ1MfkHCVG4agwpTrUxK3X6bLIUrFlY2QpKSrgXC1dPAPbaLJ&_nc_ohc=hUDK8rBPmh4AX_xTVeH&_nc_ht=scontent.fluq3-1.fna&oh=00_AT9SjbSQBMaGusXs8Z4n1fDi3O8LurPy8KQA-uKaH_YdEA&oe=633B0881'),
    ('Isenbeck', 'https://scontent.fluq3-1.fna.fbcdn.net/v/t1.18169-9/17103302_10154408796478061_3474089334054338498_n.png?_nc_cat=106&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeFK4PXb6aPiim-YsdJyrArtm96keNnWTL-b3qR42dZMv_tRDCvsiGDRA1OuhP9qjLFpu0ci4dtllx5wN99el0qx&_nc_ohc=Ytkh-1OPzf0AX-VzVqp&_nc_ht=scontent.fluq3-1.fna&oh=00_AT8z2CJPis_252t0FeQPA6URLBEkFiWuK_Y6Mg-ju9ZJhw&oe=6339C3E9'),
    ('Valmont', 'https://scontent.fluq3-1.fna.fbcdn.net/v/t1.18169-9/22046605_1675749652444909_4086562462651098789_n.png?_nc_cat=106&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeG-C78a8xQfNERWpOzm8HK-M1S007NoskYzVLTTs2iyRh4EeM6T-JtVi3PMx8V4s7b0Nzxl6J_0D_g1BC2BhQaX&_nc_ohc=26flt5B1qVkAX_N6AUg&_nc_ht=scontent.fluq3-1.fna&oh=00_AT_wmqkU-EpR5U-xQ3eyfxqve5uAEyoM3uHU9xMyaC2SUQ&oe=633D572F'),
    ('Estancia Mendoza', 'https://scontent.fluq3-1.fna.fbcdn.net/v/t1.6435-9/64607539_2360357210674284_3657424369216389120_n.png?_nc_cat=109&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeEZ0mZTL8K0Do7esZzGQTDo9pllN0rqV4z2mWU3SupXjKksb42UMxmK2YjaTy7S2-s6xvdcqFzzKNHYm1BnH4US&_nc_ohc=RkMMNaIpy9sAX8jn9lN&_nc_ht=scontent.fluq3-1.fna&oh=00_AT9IiSMn68H4tEaopDwmQXV2lhZfeP1zhoM2w98kaE_SsA&oe=633A6DC6');
--insert para tabla de sabores
INSERT
INTO
  sabores
  (nombre, estado_stock, formatos_id_fk, marcas_id_fk)
VALUES
  ('Limon', true, 4, 1),
  ('Coca', false, 4, 1),
  ('Uva', true, 4, 1),
  ( 'Rubia', false, 3, 4),
  ( 'Negra', false, 3, 4),
  ( 'Rubia', false, 3, 5),
  ( 'Tinto Suave', false, 2, 6),
  ( 'Tinto', false, 2, 6),
  ( 'Tinto Fuerte', true, 1, 6),
  ( 'Tinto Patero', true, 2, 6),
  ( 'Tinto Patero', true, 3, 6),
  ( 'Tinto Patero', true, 4, 6),