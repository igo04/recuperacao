package br.com.gestaocarro.service;

import br.com.gestaocarro.repository.CarroRepository;
import br.com.gestaocarro.domain.model.Carro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarroService {
    private static br.com.gestaocarro.repository.CarroRepository CarroRepository = null;
    public CarroService(CarroRepository massaRepository) {
        this.CarroRepository = massaRepository;
    }

    public static Carro save(Carro carro){
        return CarroRepository.save(carro);
    }

    public List<Carro> findAll(){
        return CarroRepository.findAll();
    }

    public static Carro findById(UUID id){
        return CarroRepository.findById(id).orElse(new Carro());
    }

    public void deleteById(UUID id){
        CarroRepository.deleteById(id);
    }

    public void update(UUID id, float preco) {
        CarroRepository.updateByPreco(id, preco);
    }

    public Carro findByPreco(float preco) {
        return br.com.gestaocarro.repository.CarroRepository.findByPreco(preco);
    }
}
