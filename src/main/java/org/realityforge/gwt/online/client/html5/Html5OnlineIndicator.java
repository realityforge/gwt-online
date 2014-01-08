package org.realityforge.gwt.online.client.html5;

import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import org.realityforge.gwt.online.client.OnlineIndicator;

public final class Html5OnlineIndicator
  extends OnlineIndicator
{
  public static native boolean isSupported()/*-{
    return typeof ($wnd.onLine) == "boolean";
  }-*/;

  public Html5OnlineIndicator()
  {
    this( new SimpleEventBus() );
  }

  public Html5OnlineIndicator( final EventBus eventBus )
  {
    super( eventBus );
    registerListeners0();
  }

  @Override
  public final native boolean isOnLine() /*-{
   return navigator.onLine;
  }-*/;

  private native void registerListeners0() /*-{
    var that = this;

    var onOnLine = $entry( function () {
      that.@org.realityforge.gwt.online.client.OnlineIndicator::onOnLine()();
    } );
    $wnd.addEventListener( "online", onOnLine );

    var onOffLine = $entry( function () {
      that.@org.realityforge.gwt.online.client.OnlineIndicator::onOffLine()();
    } );
    $wnd.addEventListener( "offline", onOffLine );
  }-*/;
}
