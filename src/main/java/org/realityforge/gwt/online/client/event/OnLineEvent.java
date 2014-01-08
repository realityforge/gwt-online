package org.realityforge.gwt.online.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import javax.annotation.Nonnull;
import org.realityforge.gwt.online.client.event.OnLineEvent.Handler;

/**
 * The application or browser is online.
 */
public class OnLineEvent
  extends GwtEvent<Handler>
{
  public interface Handler
    extends EventHandler
  {
    void onOnLineEvent( @Nonnull OnLineEvent event );
  }

  private static final GwtEvent.Type<Handler> TYPE = new Type<Handler>();

  public static GwtEvent.Type<Handler> getType()
  {
    return TYPE;
  }

  @Override
  public GwtEvent.Type<Handler> getAssociatedType()
  {
    return OnLineEvent.getType();
  }

  @Override
  protected void dispatch( @Nonnull final Handler handler )
  {
    handler.onOnLineEvent( this );
  }
}
