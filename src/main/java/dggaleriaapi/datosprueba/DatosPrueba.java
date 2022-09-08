package dggaleriaapi.datosprueba;

import dggaleriaapi.models.Formato;
import dggaleriaapi.models.Marca;
import dggaleriaapi.models.SaborAsociado;

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

    public static List<SaborAsociado> sabores = Arrays.asList(
            new SaborAsociado(1L, "Naranja", marcas.get(0)),
            new SaborAsociado(2L, "Coca", marcas.get(0)),
            new SaborAsociado(3L, "Limon", marcas.get(2)),
            new SaborAsociado(4L, "Tinto", marcas.get(3)),
            new SaborAsociado(5L, "Rubia", marcas.get(4))
    );

    public static List<SaborAsociado> saboresMismaMarca0 = Arrays.asList(
            new SaborAsociado(1L, "Naranja", marcas.get(0)),
            new SaborAsociado(2L, "Pomelo", marcas.get(0)),
            new SaborAsociado(3L, "Limon", marcas.get(0)),
            new SaborAsociado(4L, "Coca", marcas.get(0)),
            new SaborAsociado(5L, "CocaLight", marcas.get(0)),
            new SaborAsociado(6L, "Iokese", marcas.get(0))
    );

    public static List<SaborAsociado> saboresMismaMarcayEnStock = Arrays.asList(
            new SaborAsociado(1L, "Naranja", marcas.get(0), true),
            new SaborAsociado(2L, "Pomelo", marcas.get(0), true),
            new SaborAsociado(3L, "Limon", marcas.get(0), true),
            new SaborAsociado(4L, "Coca", marcas.get(0), true),
            new SaborAsociado(5L, "CocaLight", marcas.get(0), true),
            new SaborAsociado(6L, "Iokese", marcas.get(0),true)
    );



}
