package com.redhat.coolstore.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.redhat.coolstore.factmodel.ShoppingCart;
import com.redhat.coolstore.factmodel.ShoppingCartItem;

@Singleton
public class BRMSUtil {

	private KieContainer kContainer = null;

	public BRMSUtil() {

		KieServices kServices = KieServices.Factory.get();

		ReleaseId releaseId = kServices.newReleaseId( "com.redhat", "coolstore", "1.0.0-SNAPSHOT" );

		kContainer = kServices.newKieContainer( releaseId );

		KieScanner kScanner = kServices.newKieScanner( kContainer );


		// Start the KieScanner polling the maven repository every 1 seconds

		kScanner.start( 1000L );

		
	}
	
	public StatelessKieSession getStatelessSession() {
		
		return kContainer.newStatelessKieSession();
		
	}
	
	public KieSession getStatefulSession() {
		
		return kContainer.newKieSession();
		
	}
	
	
	
}
