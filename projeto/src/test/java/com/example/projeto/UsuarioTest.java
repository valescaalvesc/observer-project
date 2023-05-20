package com.example.projeto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    @Test
    void deveNotificarUmUsuario() {
        EDR edr = new EDR(12023, 1, "SentinelOne", "Purple");
        Usuario usuario = new Usuario("Maria");
        usuario.atualizar(edr);
        edr.atualizarSensor();
        assertEquals("Maria, edr atualizado versao EDR{versao=12023, sensor=1, nomeEDR='SentinelOne', nomeVersao='Purple'}", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        EDR edr = new EDR(12023, 1, "SentinelOne", "Purple");
        Usuario usuario1 = new Usuario("Maria");
        Usuario usuario2 = new Usuario("Ana");
        usuario1.atualizar(edr);
        usuario2.atualizar(edr);
        edr.atualizarSensor();
        assertEquals("Maria, edr atualizado versao EDR{versao=12023, sensor=1, nomeEDR='SentinelOne', nomeVersao='Purple'}", usuario1.getUltimaNotificacao());
        assertEquals("Ana, edr atualizado versao EDR{versao=12023, sensor=1, nomeEDR='SentinelOne', nomeVersao='Purple'}", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuario() {
        EDR edr = new EDR(1203, 1, "SentinelOne", "Purple");
        Usuario usuario = new Usuario("Maria");
        edr.atualizarSensor();
        assertEquals(null, usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioEDR1() {
        EDR edr1 = new EDR(12023, 1, "SentinelOne", "Purple");
        EDR edr2 = new EDR(12023, 1, "SentinelOne", "Blue");
        Usuario usuario1 = new Usuario("Maria");
        Usuario usuario2 = new Usuario("Ana");
        usuario1.atualizar(edr1);
        usuario2.atualizar(edr2);
        edr1.atualizarSensor();
        assertEquals("Maria, edr atualizado versao EDR{versao=12023, sensor=1, nomeEDR='SentinelOne', nomeVersao='Purple'}", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }
}
