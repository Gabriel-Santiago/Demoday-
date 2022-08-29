package mandacaru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mandacaru.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Integer> {
	List<Imagem> findByImovelId(int id);
}