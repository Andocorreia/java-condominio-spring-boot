package componente;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.condominio.backend.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@DirtiesContext
@ActiveProfiles("TEST")
public abstract class ApplicationComponentTest {

}

