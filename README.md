gwt-appcache
============

[![Build Status](https://secure.travis-ci.org/realityforge/gwt-online.png?branch=master)](http://travis-ci.org/realityforge/gwt-online)
[<img src="https://img.shields.io/maven-central/v/org.realityforge.gwt.online/gwt-online.svg?label=latest%20release"/>](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.realityforge.gwt.online%22%20a%3A%22gwt-online%22)

The WHATWG Web Applications 1.0 specification describes mechanisms
for detecting when the browser is "online" and supports event
notification when the online status changes. This library provides a
simple abstraction over this functionality.

Quick Start
===========

The simplest way to appcache enable a GWT application is to;

* add the following dependencies into the build system. i.e.

```xml
<dependency>
   <groupId>org.realityforge.gwt.online</groupId>
   <artifactId>gwt-online</artifactId>
   <version>0.1</version>
   <scope>provided</scope>
</dependency>
```

* add the following snippet into the .gwt.xml file.

```xml
<module rename-to='myapp'>
  ...

  <!-- Enable the client-side library -->
  <inherits name="org.realityforge.gwt.online.Online"/>
</module>
```

* interact with the application from within the browser.

```java
final OnlineIndicator indicator = OnlineIndicator.getOnlineIndicatorIfSupported();
if ( null != indicator )
{
  indicator.addOnLineHandler( new OnLineEvent.Handler()
  {
    @Override
    public void onOnLineEvent( @Nonnull final OnLineEvent event )
    {
      //synchronize with the server now that we are online...
    }
  } );
  indicator.addOffLineHandler( new OffLineEvent.Handler()
  {
    @Override
    public void onOffLineEvent( @Nonnull final OffLineEvent event )
    {
      //disable communication with the server...
    }
  } );

  if( indicator.isOnLine() )
  {
    // Have a separate code path if online...
  }

  ...
```

Appendix
--------

* [Online and offline events](https://developer.mozilla.org/en/docs/Online_and_offline_events)
* [Offline Web Application Standard](http://www.whatwg.org/specs/web-apps/current-work/multipage/offline.html)
