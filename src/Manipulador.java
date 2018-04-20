import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulador
{
    public static Properties getArestasQ1() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ1.properties");
        props.load(file);
        return props;
    }

    public static Properties getVerticesQ1() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ1.properties");
        props.load(file);
        return props;
    }

    public static Properties getArestasQ2() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ2.properties");
        props.load(file);
        return props;
    }

    public static Properties getVerticesQ2() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ2.properties");
        props.load(file);
        return props;
    }

    public static Properties getArestasQ3() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ3.properties");
        props.load(file);
        return props;
    }

    public static Properties getVerticesQ3() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ3.properties");
        props.load(file);
        return props;
    }

    public static Properties getArestasQ4() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/ArestasQ4.properties");
        props.load(file);
        return props;
    }

    public static Properties getVerticesQ4() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./Properties/VerticesQ4.properties");
        props.load(file);
        return props;
    }
}
