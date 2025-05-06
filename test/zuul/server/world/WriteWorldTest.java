package zuul.server.world;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuul.server.items.Item;
import zuul.server.world.persistence.WorldAdapter;

public class WriteWorldTest {
    WorldAdapter wa = new WorldAdapter();
    World world;
    @BeforeEach
    void setUp() {
        World originalWorld =  wa.readFromFile("test/data/campus.yml");
        String yaml = wa.export(originalWorld);
        System.out.println(yaml);
        world = wa.fromString(yaml);
    }

    @Test
    public void checkItemInPub(){
        Map<String, Room> rooms = world.getRooms();
        Room room = rooms.get("pub");
        Item mug = room.getItem("mug");
        assertNotNull(mug);
    }

    @Test
    public void checkTheaterConnection(){
        Map<String, Room> rooms = world.getRooms();
        Room room = rooms.get("theater");
        Room outside  = room.getExit("west");
        assertNotNull(outside);
    }
}
