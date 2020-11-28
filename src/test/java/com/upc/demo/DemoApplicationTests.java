package com.upc.demo;

import com.upc.demo.domain.model.*;
import com.upc.demo.service.*;
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
        MembershipPayment pagomembresia = new MembershipPayment();
        MembershipPaymentServiceImpl PMSI = new MembershipPaymentServiceImpl();
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
        void ClientTestFindAll() {
            List<Client> Expected = CSI.getAllClients();
            Assertions.assertEquals(Expected.size(), 0);
        }
        @Test
        void TestComprarMembership () {
            Long exp = (long)1;
            Membership  Expected = MSI.createMembership(exp,membresia);
            Assertions.assertSame(Expected,membresia);
        }
        @Test
        @Disabled
        void TestIngresarMembershipPayment()
        {
            MembershipPayment Expected = PMSI.createMembershipPayment((long)1,(long)1,pagomembresia);
            Assertions.assertSame(Expected,pagomembresia);
        }
        @Test
        @Disabled
        void TestAgregarCard(){
            //Card Expected = TSI.save((long) 1,tarjeta);
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
            ; */
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
            Reservation Expeted = RSI.createReservation((long) 1,reserva );
            Assertions.assertSame(Expeted, reserva);
        }

        @Test
        @Disabled
        void ReservationTestFindAll()
        {

            //List<Reservation>Actual = RSI.getAll();
            //Assertions.assertEquals(0,Actual.size());
        }

        @Test
        void ReservationTestFindbyID()
        {
            List<Reservation> Expected = RSI.getAllReservationsByServiceId((long) 1);
            Assertions.assertSame(Expected.size(),0);
        }

    }
}
