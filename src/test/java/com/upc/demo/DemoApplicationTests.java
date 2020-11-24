package com.upc.demo;

import com.upc.demo.domain.model.Card;
import com.upc.demo.domain.model.Client;
import com.upc.demo.domain.model.Membership;
import com.upc.demo.domain.model.Reservation;
import com.upc.demo.service.CardServiceImpl;
import com.upc.demo.service.ReservationServiceImpl;
import com.upc.demo.service.ClientServiceImpl;
import com.upc.demo.service.MembershipServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {
    class ClientServiceApplicationTests {
        Client cliente = new Client();
        ClientServiceImpl CSI = new ClientServiceImpl();
        Membership membresia = new Membership ();
        MembershipServiceImpl MSI = new MembershipServiceImpl();
        //PagoMembership  pagomembresia = new PagoMembership ();
        //PagoMembership ServiceImpl PMSI = new PagoMembership ServiceImpl();
        Card tarjeta = new Card();
        CardServiceImpl TSI  = new CardServiceImpl();
        Reservation reserva = new Reservation();
        ReservationServiceImpl RSI = new ReservationServiceImpl();

        @Test
        void TestAgregarCliente() {
            Client Expected = CSI.createClient(cliente);
            Assertions.assertSame(Expected, cliente);
        }


        @Test
        @Disabled
        void TestFindAll() {
            List<Client> Expected = CSI.getAllClients();
            Assertions.assertEquals(Expected.size(), 0);
        }
        @Test
        void TestComprarMembership () {
            /*Membership  Expected = MSI.createMembership((long) 1,membresia);
            Assertions.assertSame(Expected,membresia);*/
        }
        @Test
        @Disabled
        void TestIngresarPagoMembership ()
        {
            //PagoMembership  Expected = PMSI.save(pagomembresia);
            //Assertions.assertSame(Expected,pagomembresia);
        }
        @Test
        @Disabled
        void TestAgregarCard(){
           // Card Expected = TSI.((long) 1,tarjeta);
            //Assertions.assertSame(Expected, tarjeta);
        }
        @Test
        @Disabled
        void TestEliminarCard()
        {
            /*try {
                TSI.DeleteByID((long) 1);
            } finally {
                Assert.isTrue(true,"Eliminacion Correcta");
            }
            ;*/
         }

        @Test
        @Disabled
        void TestListarCards()
        {
            //List<Card> Expected = TSI.getAll();
            //Assertions.assertSame(Expected, TSI.getAll());
        }
        @Test
         void TestNuevaReservation() {
            //Assertions.assertSame(RSI.createReservation((long) 1,reserva );
        }

        @Test
        @Disabled
        void TestFindAll()
        {

            //List<Reservation>Actual = RSI.getAll();
            //Assertions.assertEquals(0,Actual.size());
        }

        @Test
        void TestFindbyID()
        {
            //Optional<Reservation> Expected = RSI.getAllReservationsByServiceId((long) 1);
            //Assertions.assertSame(Expected.get(),reserva);
        }

    }
}
