public class Libros {
    public String Libros;
    public String Autores;
    public String Prestamos;
    public String Usuarios;

    public Libros(String libros, String autores, String prestamos, String usuarios) {
        Libros = libros;
        Autores = autores;
        Prestamos = prestamos;
        Usuarios = usuarios;
    }

    public String getLibros() {
        return Libros;
    }

    public void setLibros(String libros) {
        Libros = libros;
    }

    public String getAutores() {
        return Autores;
    }

    public void setAutores(String autores) {
        Autores = autores;
    }

    public String getPrestamos() {
        return Prestamos;
    }

    public void setPrestamos(String prestamos) {
        Prestamos = prestamos;
    }

    public String getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(String usuarios) {
        Usuarios = usuarios;
    }
}
