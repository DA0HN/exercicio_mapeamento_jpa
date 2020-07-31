package org.gabriel.apps;

import org.gabriel.model.Cliente;
import org.gabriel.model.Fornecedor;
import org.gabriel.model.GrupoProduto;
import org.gabriel.model.ItemVenda;
import org.gabriel.model.Produto;
import org.gabriel.model.Venda;
import org.gabriel.model.Vendedor;
import org.gabriel.repositories.DAO;
import org.gabriel.repositories.EntityManagerUtil;

import java.time.LocalDate;

import static java.util.Arrays.asList;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class App {
    public static void main(String... args) {
        populate();
    }

    private static void populate() {
        var dao = new DAO<>(EntityManagerUtil.getEntityManager());

        var grupoProduto1 = new GrupoProduto("grupoproduto1");
        var grupoProduto2 = new GrupoProduto("grupoproduto2");
        var grupoProduto6 = new GrupoProduto("grupoproduto6");
        var grupoProduto7 = new GrupoProduto("grupoproduto7");

        var produto1 = new Produto("produto1", 25.79f);
        var produto2 = new Produto("produto2", 28.12f);
        var produto3 = new Produto("produto3", 123.53f);
        var produto4 = new Produto("produto4", 2745.42f);
        var produto5 = new Produto("produto5", 2124.56f);
        var produto6 = new Produto("produto6", 254.70f);
        var produto7 = new Produto("produto7", 213.86f);
        var produto8 = new Produto("produto8", 124.7f);

        var fornecedor1 = new Fornecedor("fornecedor1");
        var fornecedor2 = new Fornecedor("fornecedor2");
        var fornecedor3 = new Fornecedor("fornecedor3");
        var fornecedor4 = new Fornecedor("fornecedor4");
        var fornecedor5 = new Fornecedor("fornecedor5");

        var itemVenda1 = new ItemVenda(1, 31, 43.98f);
        var itemVenda2 = new ItemVenda(7, 21, 12.87f);
        var itemVenda3 = new ItemVenda(1, 41, 15.67f);
        var itemVenda4 = new ItemVenda(11, 11, 83.15f);
        var itemVenda5 = new ItemVenda(21, 11, 74.12f);
        var itemVenda6 = new ItemVenda(10, 64, 56.99f);
        var itemVenda7 = new ItemVenda(7, 75, 89.57f);
        var itemVenda8 = new ItemVenda(8, 90, 99.53f);
        var itemVenda9 = new ItemVenda(14, 1, 12.68f);
        var itemVenda10 = new ItemVenda(6, 2, 125.64f);

        var venda1 = new Venda(LocalDate.now()
                                       .minusDays(11)
                                       .minusMonths(35));
        var venda2 = new Venda(LocalDate.now()
                                       .minusDays(9)
                                       .minusMonths(13));
        var venda3 = new Venda(LocalDate.now()
                                       .minusDays(24)
                                       .minusMonths(57));
        var venda4 = new Venda(LocalDate.now()
                                       .minusDays(12)
                                       .minusMonths(12));
        var venda5 = new Venda(LocalDate.now()
                                       .minusDays(8)
                                       .minusMonths(4));
        var venda6 = new Venda(LocalDate.now()
                                       .minusDays(3)
                                       .minusMonths(5));
        var venda7 = new Venda(LocalDate.now()
                                       .minusDays(1)
                                       .minusMonths(2));

        var vendedor1 = new Vendedor("vendedor1", 15f);
        var vendedor2 = new Vendedor("vendedor2", 15f);
        var vendedor3 = new Vendedor("vendedor3", 15f);
        var vendedor4 = new Vendedor("vendedor4", 15f);

        var cliente1 = new Cliente("cliente1");
        var cliente2 = new Cliente("cliente2");
        var cliente3 = new Cliente("cliente3");

        dao.begin()
                .save(venda1)
                .save(venda2)
                .save(venda3)
                .save(venda4)
                .save(venda5)
                .save(venda6)
                .commit();

        cliente1.setVendas(asList(venda1, venda2));
        cliente2.setVendas(asList(venda3, venda6));
        cliente3.setVendas(asList(venda4, venda5, venda7));

        venda1.setCliente(cliente1);
        venda2.setCliente(cliente1);
        venda3.setCliente(cliente2);
        venda4.setCliente(cliente3);
        venda5.setCliente(cliente3);
        venda6.setCliente(cliente2);
        venda7.setCliente(cliente3);

        dao.begin()
                .save(cliente1)
                .save(cliente2)
                .save(cliente3)
                .commit();
    }
}