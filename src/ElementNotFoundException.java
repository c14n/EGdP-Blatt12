import java.util.NoSuchElementException;

/**
 * Created by cmartin on 20.12.16.
 */
public class ElementNotFoundException extends NoSuchElementException
{
    public ElementNotFoundException(Object key)
    {
        super(String.format(
                "Das Element mit Schlüssel %s ist nicht in der Map enthalten", key
        ));
    }
}
