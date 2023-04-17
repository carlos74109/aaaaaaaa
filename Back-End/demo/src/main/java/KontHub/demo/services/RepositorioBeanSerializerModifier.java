package KontHub.demo.services;
import KontHub.demo.Models.Repositorio;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class RepositorioBeanSerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (Repositorio.class.isAssignableFrom(beanDesc.getBeanClass())) {
            return new RepositorioSerializer((JsonSerializer<Object>) serializer);
        }
        return serializer;
    }
}
