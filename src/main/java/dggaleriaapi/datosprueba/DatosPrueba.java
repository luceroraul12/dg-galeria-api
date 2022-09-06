package dggaleriaapi.datosprueba;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Marca;
import dggaleriaapi.models.Sabor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatosPrueba {

    public static List<Formato> formatos = Arrays.asList(
            new Formato(1L, "500ml"),
            new Formato(2L, "750ml"),
            new Formato(3L, "1.25l"),
            new Formato(4L, "2.2l"),
            new Formato(5L, "3l")
    );

    public static List<Marca> marcas = Arrays.asList(
            new Marca(1L, "Talca"),
            new Marca(2L, "Sprite"),
            new Marca(3L, "VinoS"),
            new Marca(4L, "Mendoza"),
            new Marca(5L, "Lemon")
    );

    public static List<Sabor> sabores = Arrays.asList(
            new Sabor(1L, "Naranja", marcas.get(0)),
            new Sabor(2L, "Coca", marcas.get(0)),
            new Sabor(3L, "Limon", marcas.get(2)),
            new Sabor(4L, "Tinto", marcas.get(3)),
            new Sabor(5L, "Rubia", marcas.get(4))
    );



}
