package vista;

import Data.Persona;
import Data.Valor;
import Modelo.OperacionesPila;
import Modelo.Pila;

/**
 *
 * @author dacastro
 */
public class Tools
{

    /**
     * Metodo que recibe una pila y convierte su contenido en un documento en formato
     * HTML para su posterior visualización.
     * El metodo hace usa copia profunda para asegurar que no se toquen o destruyan los datos 
     * de la pila original <code>p</code>.
     * @param p
     * @return 
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: String convertirPilaAHtml(Pila<Valor>)">
    public static String convertirPilaAHtml(Pila<Persona> p)
    {
        StringBuilder sb = new StringBuilder("<html>");
        Pila<Persona> q = OperacionesPila.duplicar(p);
        
        sb.append("<noscript>").append("</noscript>");
        
        if (!q.estaVacio())
        {
            sb.append("<table align=\"center\" border=\"2\">");
            sb.append("<th>").append("Nombre").append("</th>");
            sb.append("<th>").append("Telefono").append("</th>");
            sb.append("<th>").append("Edad").append("</th>");
            do
            {
                Persona e = q.desapilar();
                sb.append("<tr>").append("<td>");
                sb.append(e.getNombre());
                sb.append("<td>").append(" " + e.getTelefono()).append("</td>");
                sb.append("<td>").append(" " + e.getEdad()).append("</td>");
                sb.append("</td>").append("</tr>");
            }
            while (!q.estaVacio());
            sb.append("</table>");
        }
        else
        {
            sb.append("<h1 align=\"center\">").append("Pila Vacia").append("</h1>");
        }
        
        sb.append("</html>");
        
        return sb.toString();
    }
    //</editor-fold>

    /**
     * Metodo que inyecta código HTML en un documento buscando la marca <code>script</code>, esto es util
     * para delegar tareas que no se deben o quieren realizar en el procesamiento principal.
     * @param p
     * @param texto
     * @return 
     */
    //<editor-fold defaultstate="collapsed" desc="String convertirPilaAHtml(Pila<Valor> p, String texto)">
    public static String convertirPilaAHtml(Pila<Persona> p, String texto)
    {
        String html = "<br><center>Se retiro " + texto + "</center></br>";
        StringBuilder sb = new StringBuilder(convertirPilaAHtml(p));
        try
        {
            sb.replace(sb.indexOf("<noscript>"), sb.indexOf("</noscript>"), html);
        }
        catch (StringIndexOutOfBoundsException ex)
        {
        }
        
        return sb.toString();
    }
    //</editor-fold>
}
