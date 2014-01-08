package org.realityforge.gwt.online.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import org.mockito.Mockito;
import org.realityforge.gwt.online.client.event.OffLineEvent;
import org.realityforge.gwt.online.client.event.OnLineEvent;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class OnlineIndicatorTest
{
  @Test
  public void registryTest()
  {
    assertNull( OnlineIndicator.getOnlineIndicatorIfSupported() );
    OnlineIndicator.register( new TestOnlineIndicator( new SimpleEventBus() ) );
    assertNotNull( OnlineIndicator.getOnlineIndicatorIfSupported() );
    final OnlineIndicator onlineIndicator = OnlineIndicator.getOnlineIndicatorIfSupported();
    assertTrue( OnlineIndicator.deregister( onlineIndicator ) );
    assertNull( OnlineIndicator.getOnlineIndicatorIfSupported() );
    assertFalse( OnlineIndicator.deregister( onlineIndicator ) );
  }

  @Test
  public void handlerInteractions()
  {
    final TestOnlineIndicator indicator = new TestOnlineIndicator( new SimpleEventBus() );

    {
      final OnLineEvent.Handler handler = mock( OnLineEvent.Handler.class );
      final HandlerRegistration registration = indicator.addOnLineEventHandler( handler );
      indicator.onOnLine();
      verify( handler, only() ).onOnLineEvent( Mockito.<OnLineEvent>anyObject() );
      registration.removeHandler();
      indicator.onOnLine();
      verify( handler, atMost( 1 ) ).onOnLineEvent( Mockito.<OnLineEvent>anyObject() );
    }

    {
      final OffLineEvent.Handler handler = mock( OffLineEvent.Handler.class );
      final HandlerRegistration registration = indicator.addOffLineEventHandler( handler );
      indicator.onOffLine();
      verify( handler, only() ).onOffLineEvent( Mockito.<OffLineEvent>anyObject() );
      registration.removeHandler();
      indicator.onOffLine();
      verify( handler, atMost( 1 ) ).onOffLineEvent( Mockito.<OffLineEvent>anyObject() );
    }
  }
}
