package org.realityforge.gwt.online.client;

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import javax.annotation.Nonnull;
import org.realityforge.gwt.online.client.event.OffLineEvent;
import org.realityforge.gwt.online.client.event.OnLineEvent;
import org.realityforge.gwt.online.client.html5.Html5OnlineIndicator;

public abstract class OnlineIndicator
{
  private static OnlineIndicator g_cache;

  private final EventBus _eventBus;

  public static OnlineIndicator getOnlineIndicatorIfSupported()
  {
    if ( null == g_cache )
    {
      if ( GWT.isClient() && Html5OnlineIndicator.isSupported() )
      {
        register( new Html5OnlineIndicator() );
      }
    }
    return g_cache;
  }

  public static void register( @Nonnull final OnlineIndicator onlineIndicator )
  {
    g_cache = onlineIndicator;
  }

  public static boolean deregister( @Nonnull final OnlineIndicator onlineIndicator )
  {
    if ( g_cache != onlineIndicator )
    {
      return false;
    }
    else
    {
      g_cache = null;
      return true;
    }
  }

  protected OnlineIndicator( final EventBus eventBus )
  {
    _eventBus = eventBus;
  }

  /**
   * @return true if browser is online.
   */
  public abstract boolean isOnLine();

  @Nonnull
  public final HandlerRegistration addOffLineHandler( @Nonnull OffLineEvent.Handler handler )
  {
    return _eventBus.addHandler( OffLineEvent.getType(), handler );
  }

  @Nonnull
  public final HandlerRegistration addOnLineHandler( @Nonnull OnLineEvent.Handler handler )
  {
    return _eventBus.addHandler( OnLineEvent.getType(), handler );
  }

  /**
   * Fire an OffLine event.
   */
  protected final void onOffLine()
  {
    _eventBus.fireEventFromSource( new OffLineEvent(), this );
  }

  /**
   * Fire an OnLine event.
   */
  protected final void onOnLine()
  {
    _eventBus.fireEventFromSource( new OnLineEvent(), this );
  }
}
