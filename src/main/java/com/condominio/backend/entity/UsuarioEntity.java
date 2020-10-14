package com.condominio.backend.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.condominio.backend.core.enums.ExpiracaoSenha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "pessoaId")
	private PessoaEntity pessoaId;

	@Column(unique = true)
	private String usuario;
	private String senha;
	private LocalDate ultimaAlteracaoSenha;
	private Boolean bloqueado;

	public void setSenha(final String senha) {
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<PerfilEntity> perfis = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		final Period period = Period.between(this.ultimaAlteracaoSenha.plusDays(ExpiracaoSenha.DIAS.getDias()), LocalDate.now());

		if (period.getDays() <= 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.bloqueado;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
