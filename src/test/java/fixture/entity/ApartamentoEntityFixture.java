package fixture.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.core.enums.Bloco;
import com.condominio.backend.entity.ApartamentoEntity;

public class ApartamentoEntityFixture implements TemplateLoader {

	@Override
	public void load() {

		Fixture.of(ApartamentoEntity.class).addTemplate("valid1", new Rule() {
			{
				add("id", new Long(2));
				add("apartamento", "11");
				add("bloco", Bloco.AVANT);
			}
		});

		Fixture.of(ApartamentoEntity.class).addTemplate("valid2", new Rule() {
			{
				add("id", new Long(1));
				add("apartamento", "131");
				add("bloco", Bloco.MODERN);
			}
		});

		Fixture.of(ApartamentoEntity.class).addTemplate("valid3", new Rule() {
			{
				add("id", new Long(4));
				add("apartamento", "192");
				add("bloco", Bloco.AVANT);
			}
		});

		Fixture.of(ApartamentoEntity.class).addTemplate("valid4", new Rule() {
			{
				add("id", new Long(3));
				add("apartamento", "1");
				add("bloco", Bloco.MODERN);
			}
		});

		Fixture.of(ApartamentoEntity.class).addTemplate("valid5", new Rule() {
			{
				add("id", new Long(5));
				add("apartamento", "192");
				add("bloco", Bloco.MODERN);
			}
		});
	}
}
