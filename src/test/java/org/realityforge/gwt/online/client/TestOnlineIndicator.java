package org.realityforge.gwt.online.client;

import com.google.web.bindery.event.shared.EventBus;

final class TestOnlineIndicator
  extends OnlineIndicator
{
  TestOnlineIndicator( final EventBus eventBus )
  {
    super( eventBus );
  }

  @Override
  public boolean isOnLine()
  {
    return false;
  }
}
