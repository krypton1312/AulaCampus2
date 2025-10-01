package act1.pkg15t2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Act115T2 {

    public static void main(String[] args) {
        ObjectContainer con = Db4oEmbedded.openFile("libros.db4o");
        Scanner sc = new Scanner(System.in);

        con.close();
    }

    public static void introducir(Scanner sc, ObjectContainer con) {
        Libro libro = new Libro();
        System.out.println("Datos del libro: ");
        System.out.print("ISBN:");
        libro.setIsbn(sc.nextLine());

        System.out.print("Titulo: ");
        libro.setTitulo(sc.nextLine());

        System.out.print("Autor: ");
        libro.setAutor(sc.nextLine());

        System.out.print("Editorial: ");
        libro.setEditorial(sc.nextLine());

        System.out.print("Categoria: ");
        libro.setCategoria(sc.nextLine());

        System.out.print("Sinopsis: ");
        libro.setSinopsis(sc.nextLine());

        System.out.print("Paginas: ");
        libro.setPaginas(sc.nextInt());
        sc.nextLine();

        System.out.print("Idioma: ");
        libro.setIdioma(sc.nextLine());

        System.out.print("Anyo de publicacion: ");
        libro.setAnyopublicacion(sc.nextInt());
        sc.nextLine();

        System.out.print("Precio: ");
        libro.setPrecio(sc.nextDouble());
        sc.nextLine();

        System.out.println("Novedad: ");
        libro.setNovedad(sc.nextBoolean());

        con.store(libro);
    }

    public static Libro buscarPorISBN(Scanner sc, ObjectContainer con) {
        System.out.println("Introduce ISBN del libro:");
        String isbn = sc.nextLine();

        ObjectSet<Libro> result = con.queryByExample(
                new Libro(isbn, null, null, null, null, null, 0, null, 0, 0.0, null)
        );

        if (result.hasNext()) {
            Libro libro = result.next();
            System.out.println("Libro encontrado: " + libro);
            return libro;
        } else {
            System.out.println("No se encontró ningún libro con ese ISBN.");
            return null;
        }
    }

    public static void eliminarPorISBN(Scanner sc, ObjectContainer con) {
        Libro libro = buscarPorISBN(sc, con);
        if (libro != null) {
            con.delete(libro);
            System.out.println("Libro eliminado: " + libro);
        } else {
            System.out.println("No se pudo eliminar porque no existe ese ISBN.");
        }
    }

    private static void actualizarCampos(Libro libro, Scanner sc) {
        System.out.print("Nuevo título (enter para dejar igual): ");
        String titulo = sc.nextLine();
        if (!titulo.isEmpty()) {
            libro.setTitulo(titulo);
        }

        System.out.print("Nuevo autor (enter para dejar igual): ");
        String autor = sc.nextLine();
        if (!autor.isEmpty()) {
            libro.setAutor(autor);
        }

        System.out.print("Nueva editorial (enter para dejar igual): ");
        String editorial = sc.nextLine();
        if (!editorial.isEmpty()) {
            libro.setEditorial(editorial);
        }

        System.out.print("Nueva categoría (enter para dejar igual): ");
        String categoria = sc.nextLine();
        if (!categoria.isEmpty()) {
            libro.setCategoria(categoria);
        }

        System.out.print("Nueva sinopsis (enter para dejar igual): ");
        String sinopsis = sc.nextLine();
        if (!sinopsis.isEmpty()) {
            libro.setSinopsis(sinopsis);
        }

        System.out.print("Nuevas páginas (0 para dejar igual): ");
        int paginas = sc.nextInt();
        sc.nextLine();
        if (paginas > 0) {
            libro.setPaginas(paginas);
        }

        System.out.print("Nuevo idioma (enter para dejar igual): ");
        String idioma = sc.nextLine();
        if (!idioma.isEmpty()) {
            libro.setIdioma(idioma);
        }

        System.out.print("Nuevo año de publicación (0 para dejar igual): ");
        int anyo = sc.nextInt();
        sc.nextLine();
        if (anyo > 0) {
            libro.setAnyopublicacion(anyo);
        }

        System.out.print("Nuevo precio (0 para dejar igual): ");
        double precio = sc.nextDouble();
        sc.nextLine();
        if (precio > 0) {
            libro.setPrecio(precio);
        }

        System.out.print("Es novedad? (true/false, enter para dejar igual): ");
        String novedadStr = sc.nextLine();
        if (!novedadStr.isEmpty()) {
            libro.setNovedad(Boolean.parseBoolean(novedadStr));
        }
    }

    public static void modificarLibro(Scanner sc, ObjectContainer con) {
        Libro libro = buscarPorISBN(sc, con);
        if (libro != null) {
            actualizarCampos(libro, sc);
            con.store(libro);
            System.out.println("Libro modificado: " + libro);
        }
    }

    public static void mostrarTodos(ObjectContainer con) {
        ObjectSet<Libro> result = con.queryByExample(new Libro(null, null, null, null, null, null, 0, null, 0, 0.0, null));
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void mostrarPorPrecio(Scanner sc, ObjectContainer con) {
        System.out.println("Mostrar datos por precio igual o superior: ");
        System.out.println("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        ObjectSet<Libro> result = con.query(new Predicate<Libro>() {
            @Override
            public boolean match(Libro libro) {
                return libro.getPrecio() >= precio;
            }
        });

        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void mostrarPorAnyo(Scanner sc, ObjectContainer con) {
        System.out.println("Mostrar datos del libro por anyo entre: ");
        System.out.println("Anyo inicial: ");
        int anyoInicial = sc.nextInt();
        sc.nextLine();
        System.out.println("Anyo Final: ");
        int anyoFinal = sc.nextInt();
        sc.nextLine();

        ObjectSet<Libro> result = con.query(new Predicate<Libro>() {
            @Override
            public boolean match(Libro libro) {
                return libro.getAnyopublicacion() > anyoInicial
                        && libro.getAnyopublicacion() < anyoFinal;
            }
        });

        while (result.hasNext()) {
            System.out.println(result.next());
        }

    }

    public static void mostrarPorAutor(Scanner sc, ObjectContainer con) {
        System.out.println("Introduce autor del libro.");
        String autor = sc.nextLine();

        ObjectSet<Libro> result = con.queryByExample(new Libro(null, null, autor, null, null, null, 0, null, 0, 0.0, null));
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void mostrarPorEditorialYCategoria(Scanner sc, ObjectContainer con) {
        System.out.println("Introduce editorial del libro.");
        String editorial = sc.nextLine();
        System.out.println("Introduce categoria del libro.");
        String categoria = sc.nextLine();

        ObjectSet<Libro> result = con.queryByExample(new Libro(null, null, null, editorial, categoria, null, 0, null, 0, 0.0, null));
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void mostrarPorPaginas(Scanner sc, ObjectContainer con) {
        System.out.println("Mostrar datos del libro por paginas igual o inferior: ");
        System.out.println("Paginas: ");
        int paginas = sc.nextInt();
        sc.nextLine();

        ObjectSet<Libro> result = con.query(new Predicate<Libro>() {
            @Override
            public boolean match(Libro libro) {
                return libro.getPaginas() <= paginas;
            }
        });

        while (result.hasNext()) {
            System.out.println(result.next());
        }

    }

    public static void mostrarPorNovedad(Scanner sc, ObjectContainer con) {
        System.out.print("Mostrar libros por novedad?.");
        Boolean novedad = sc.nextBoolean();

        ObjectSet<Libro> result = con.queryByExample(new Libro(null, null, null, null, null, null, 0, null, 0, 0.0, novedad));
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void mostrarPorIdiomas(Scanner sc, ObjectContainer con) {
        System.out.println("Introduce idiomas (escribe 0 para terminar): ");
        List<String> idiomas = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }
            idiomas.add(input);
        }

        ObjectSet<Libro> result = con.query(new Predicate<Libro>() {
            @Override
            public boolean match(Libro libro) {
                return idiomas.contains(libro.getIdioma());
            }
        });

        if (result.isEmpty()) {
            System.out.println("No se encontraron libros para los idiomas introducidos.");
        } else {
            while (result.hasNext()) {
                System.out.println(result.next());
            }
        }
    }

    public static void mostrarPorSinopsisContains(Scanner sc, ObjectContainer con) {
        System.out.println("Introduce parte del sinopsis: ");
        String sinopsis = sc.nextLine();

        ObjectSet<Libro> result = con.query(new Predicate<Libro>() {
            @Override
            public boolean match(Libro libro) {
                return libro.getSinopsis().contains(sinopsis);
            }
        });
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }
}
