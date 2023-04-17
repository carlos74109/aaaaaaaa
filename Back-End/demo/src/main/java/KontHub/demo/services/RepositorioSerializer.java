package KontHub.demo.services;
import KontHub.demo.Models.Repositorio;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;

import java.io.IOException;

public class RepositorioSerializer extends JsonSerializer<Repositorio> {

    private final JsonSerializer<Object> defaultSerializer;

    public RepositorioSerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = defaultSerializer;
    }

    @Override
    public void serialize(Repositorio repositorio, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("nome", repositorio.getName());
        gen.writeStringField("tipoPrivado", repositorio.getPrivado().toString());
        gen.writeStringField("descricao", repositorio.getDescription());
        gen.writeStringField("Data_update", repositorio.getUpdated_at());
        gen.writeStringField("svn_url", repositorio.getSvn_url());
        gen.writeStringField("linguagem", repositorio.getLanguage());

        // Outros campos que você precisa serializar
        gen.writeEndObject();
    }

    @Override
    public boolean isEmpty(SerializerProvider provider, Repositorio value) {
        return value == null;
    }

    @Override
    public JsonSerializer<Repositorio> unwrappingSerializer(NameTransformer transformer) {
        return this;
    }


}
