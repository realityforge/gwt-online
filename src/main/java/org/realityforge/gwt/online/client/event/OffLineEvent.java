package org.realityforge.gwt.online.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import javax.annotation.Nonnull;
import org.realityforge.gwt.online.client.event.OffLineEvent.Handler;

/**
 * The application or browser is offline.
 */
public class OffLineEvent
  extends GwtEvent<Handler>
{
  public interface Handler
    extends EventHandler
  {
    void onOffLineEvent( @Nonnull OffLineEvent event );
  }

  private static final Type<Handler> TYPE = new Type<Handler>();

  public static Type<Handler> getType()
  {
    return TYPE;
  }

  @Override
  public Type<Handler> getAssociatedType()
  {
    return OffLineEvent.getType();
  }

  @Override
  protected void dispatch( @Nonnull final Handler handler )
  {
    handler.onOffLineEvent( this );
  }
}
