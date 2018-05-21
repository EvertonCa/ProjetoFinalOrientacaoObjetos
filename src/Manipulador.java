/**
 / Classe responsavel por manipular as properties que armazenam as Ruas, Arestas, Vertices e Semaforos
 **/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulador
{
    /// retorna a property das arestas do quadrante 1
    public static Properties getArestasQ1() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ1.properties");
        props.load(file);
        return props;
    }

    /// retorna a property dos vertices do quadrante 1
    public static Properties getVerticesQ1() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ1.properties");
        props.load(file);
        return props;
    }

    /// retorna a property das ruas do quadrante 1
    public static Properties getRuasQ1() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/RuasQ1.properties");
        props.load(file);
        return props;
    }

    /// retorna a property das arestas do quadrante 2
    public static Properties getArestasQ2() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ2.properties");
        props.load(file);
        return props;
    }

    /// retorna a property dos vertices do quadrante 2
    public static Properties getVerticesQ2() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ2.properties");
        props.load(file);
        return props;
    }

    /// retorna a property das ruas do quadrante 2
    public static Properties getRuasQ2() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/RuasQ2.properties");
        props.load(file);
        return props;
    }

    /// retorna a property das arestas do quadrante 3
    public static Properties getArestasQ3() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ3.properties");
        props.load(file);
        return props;
    }

    /// retorna a property dos vertices do quadrante 3
    public static Properties getVerticesQ3() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ3.properties");
        props.load(file);
        return props;
    }

    /// retorna a property das ruas do quadrante 3
    public static Properties getRuasQ3() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/RuasQ3.properties");
        props.load(file);
        return props;
    }

    /// retorna a property das arestas do quadrante 4
    public static Properties getArestasQ4() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ4.properties");
        props.load(file);
        return props;
    }

    /// retorna a property dos vertices do quadrante 4
    public static Properties getVerticesQ4() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ4.properties");
        props.load(file);
        return props;
    }

    /// retorna a property das ruas do quadrante 4
    public static Properties getRuasQ4() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/RuasQ4.properties");
        props.load(file);
        return props;
    }

    public static Properties getInterseccoesQ1() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/SemaforosQ1.properties");
        props.load(file);
        return props;
    }
    public static Properties getInterseccoesQ2() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/SemaforosQ2.properties");
        props.load(file);
        return props;
    }
    public static Properties getInterseccoesQ3() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/SemaforosQ3.properties");
        props.load(file);
        return props;
    }
    public static Properties getInterseccoesQ4() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/SemaforosQ4.properties");
        props.load(file);
        return props;
    }
}
