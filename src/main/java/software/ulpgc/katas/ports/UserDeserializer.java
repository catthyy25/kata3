package software.ulpgc.katas.ports;

import software.ulpgc.katas.model.User;

import java.util.List;

public interface UserDeserializer {
    List<User> deserialize(String value);
}
