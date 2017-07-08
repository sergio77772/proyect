package test.Droidlogin;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.R.drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends FragmentActivity {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mapas);
	        
	        GoogleMap mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
	        
	        mapa.setMyLocationEnabled(true);
	        cargarVista(mapa);
	        
	       addMarkers(mapa);
	 
	        mapa.setOnMarkerClickListener(new OnMarkerClickListener() {
	            public boolean onMarkerClick(Marker marker) {
	                Toast.makeText(
	                    MapaActivity.this,
	                    "Marcador presionado:\n" +
	                    marker.getTitle(),
	                    Toast.LENGTH_SHORT).show();
	         
	                return false;
	            }
	        });
	        
	        mapa.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
				@Override
				public void onInfoWindowClick(Marker marker) {
					Toast.makeText(
		                    MapaActivity.this,
		                    "Detalle de marcador:\n" +
		                    marker.getSnippet(),
		                    Toast.LENGTH_SHORT).show();
				}
			});
	 }
	 
	 private void addMarkers(GoogleMap mapa) {
		  mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.252415,-65.276396))
	        .title("SUBCOMITE-DE FERNANDO BACA")
	        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_muni))
	        .snippet("TODO EL DIA"));
		  
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.200866, -65.289975))
	        .title("SUBCOMITE-DE FERNANDO BACA 2")
	        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_muni))
	        .snippet("CARTELERIA"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.122114, -65.154374))
	        .title("DIRIGENTE DE EJEMPLO")
	        //icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_muni))
	        .snippet("BANDERAS Y CARTELES EN LA MAÑANA"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.260294, -65.214676))
	        .title("39 VIVIENDAS E INFR. EN EL ARENAL relocalizadas en PALPALA:")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_muni))
	        .snippet("AVANCE DE OBRA FISICO: 31,91%"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.183939, -65.301941))
	        .title("61 VIVIENDAS E INFRAESTRUCTURA EN PALPALA:")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 34,18%"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.250768, -65.1916634))
	        .title("34 VIV. E INFR. EN EL ARENAL - TD - (RELOC. EN RIO BLANCO - DPTO. PALPALA)")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 59,59%"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.250768,-65.1916634))
	        .title("50 VIVIENDAS E INFR. EN PALPALA - TD")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 59,68%"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.386101,-65.255145))
	        .title("40 VIVIENDAS E INFRAESTRUCUTRA EN EL CARMEN - ADEP")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 96,11%"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.385678,-65.142956))
	        .title("100 VIV E INF EN PERICO TD - (RELOC EN MONTERRICO)")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 11,33%"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.251103,-64.86094))
	        .title("30 VIV E INF EN SAN PEDRO")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 96,9%"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.226779,-64.852913))
	        .title("50 VIVIENDAS E INFR. EN SAN PEDRITO C")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 4,21%"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.221277,-64.8404414))
	        .title("15 VIV. E INF. EN LA ESPERANZA")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 48,69%"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-23.79037,-64.773902))
	        .title("80 VIV E INF EN LGSM 1 (RELOC EN H. HONDO S.S. DE JUJUY")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 0%"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-23.79037,-64.773902))
	        .title("48 VIV E INF EN BAJO LA VIÑA - TD (RELOC EN H. HONDO S.S. DE JUJUY")
	       // .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
	        .snippet("AVANCE DE OBRA FISICO: 2.54"));
	}

	  /*  @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.activity_main, menu);
	        return true;
	    }*/
	 public void cargarVista(GoogleMap mapa)
	 {
	 LatLng jujuy = new LatLng(-24.196321, -65.293543);
     CameraPosition camPos = new CameraPosition.Builder()
             .target(jujuy)  	  //Centramos 
             .zoom(10)         //Establecemos el zoom en 18
             .bearing(45)      //Establecemos la orientación con el noreste arriba
             .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
             .build();
      
     CameraUpdate camUpd3 =
         CameraUpdateFactory.newCameraPosition(camPos);
      
     mapa.animateCamera(camUpd3);}
	 
}
