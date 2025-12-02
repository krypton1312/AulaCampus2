package act8.pkg14;

import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Act814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ODB odb = ODBFactory.open("libros.neo");
        
        introducir(odb);
        introducir(odb);
        
        listar(odb);
        System.out.println("Buscar por isbn:");
        listarIBSN(odb, sc);
        System.out.println("Actualizar");
        actualizar(odb, sc);
        System.out.println("Buscar por isbn para ver cambios:");
        listarIBSN(odb, sc);
        System.out.println("eliminar:");
        eliminarIBSN(odb, sc);
        
        
        odb.close();
    }
    
    private static Libro pedirDatos(Scanner sc, boolean actualizacion){
        Libro libro = new Libro();
        
        System.out.println("Introduce datos del libro.");
        if(!actualizacion){
            System.out.println("ISBN: ");
            libro.setISBN(sc.nextLine());
        }
        
        System.out.println("Titulo:");
        libro.setTitulo(sc.nextLine());
        
        System.out.println("Autor:");
        libro.setAutor(sc.nextLine());
        
        System.out.println("Editorial:");
        libro.setEditorial(sc.nextLine());
        
        System.out.println("Categoria:");
        libro.setCategoria(sc.nextLine());
        
        System.out.println("Sinopsis:");
        libro.setSinopsis(sc.nextLine());
        
        System.out.println("Paginas:");
        libro.setPaginas(sc.nextInt());
        sc.nextLine();
        
        System.out.println("Idioma:");
        libro.setIdioma(sc.nextLine());
        
        System.out.println("Anyo Publicacion:");
        libro.setAnyoPublicacion(sc.nextInt());
        sc.nextLine();
        
        System.out.println("Precio:");
        libro.setPrecio(sc.nextDouble());
        sc.nextLine();
        
        System.out.println("Es novedad:");
        libro.setNovedad(sc.nextBoolean());
        sc.nextLine();
        
        return libro;
    }
    
    private static void introducir(ODB odb){
        odb.store(pedirDatos(new Scanner(System.in), false));
    }
    
    private static void listar(ODB odb){
        Objects<Libro> obj = odb.getObjects(Libro.class);
        
        while(obj.hasNext()){
            System.out.println(obj.next());
        }
    }
    
    public static Libro listarIBSN(ODB odb, Scanner sc){
        System.out.println("ISBN para buscar: ");
        ICriterion condicion = Where.equal("ISBN", sc.nextLine());
        CriteriaQuery consulta = new CriteriaQuery(Libro.class, condicion);
        
        Objects<Libro> obj = odb.getObjects(consulta);
        
        return obj.getFirst();
    }
    
    public static void eliminarIBSN(ODB odb, Scanner sc){
        Libro libro = listarIBSN(odb, sc);
        odb.delete(libro);
        System.out.println("Eliminado: " + libro);
    }
    
    public static void actualizar(ODB odb, Scanner sc){
        Libro libroParaActualizar = listarIBSN(odb, sc);
        
        Libro nuevosDatos = pedirDatos(sc, true);
        nuevosDatos.setISBN(libroParaActualizar.getISBN());
        
        odb.store(nuevosDatos);
    }
    
    // act 8-14
    
    public static void realizarBusqueda(ODB odb, ICriterion condicion){
        CriteriaQuery consulta = new CriteriaQuery(Libro.class, condicion);
        
        Objects<Libro> obj = odb.getObjects(consulta);
        
        for(Libro l: obj){
            System.out.println(l);
        }
    }
    
    public static void buscarPorPrecio(ODB odb, Scanner sc){
        System.out.println("Buscar por precio mayor o igual: ");
        
        realizarBusqueda(odb, Where.ge("precio", sc.nextDouble()));
        sc.nextLine();
    }
    
    public static void buscarEntreAnyos(ODB odb, Scanner sc){
        System.out.println("Introduce anyo inicial: ");
        int anyoInicial = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce anyo final: ");
        int anyoFinal = sc.nextInt();
        sc.nextLine();
        
        realizarBusqueda(odb, new And()
            .add(Where.ge("anyoPublicacion", anyoInicial))
            .add(Where.le("anyoPublicacion", anyoFinal)));
    }
    
    public static void buscarPorAutor(ODB odb, Scanner sc){
        System.out.println("Introduce un autor: ");
        
        realizarBusqueda(odb, Where.equal("autor", sc.nextLine()));
    }
    
    public static void buscarPorEditorialYCategoria(ODB odb, Scanner sc){
        System.out.println("Introduce un editorial: ");
        String editorial = sc.nextLine();
        
        System.out.println("Introduce una categoria");
        String categoria = sc.nextLine();
        
        realizarBusqueda(odb, new And()
            .add(Where.equal("categoria", categoria))
            .add(Where.equal("editorial", editorial)));
    }
    
    public static void buscarPorPaginasInferior(ODB odb, Scanner sc){
        System.out.println("Numero de paginas: ");
        int paginas = sc.nextInt();
        sc.nextLine();
        
        realizarBusqueda(odb, Where.lt("paginas", paginas));
    }
    
    public static void buscarPorNovedad(ODB odb, Scanner sc){
        System.out.println("Libro es novedad: ");
        boolean isNovedad = sc.nextBoolean();
        sc.nextLine();
        
        realizarBusqueda(odb, Where.equal("novedad", isNovedad));
    }
    
    public static void buscarPorSinopsis(ODB odb, Scanner sc){
        System.out.println("Introduce una parte del sinopsis: ");
        
        realizarBusqueda(odb, Where.contain("sinopsis", sc.nextLine()));
    }
}
