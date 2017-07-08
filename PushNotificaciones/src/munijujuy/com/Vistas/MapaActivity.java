package munijujuy.com.Vistas;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import munijujuy.com.R;
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
	        .position(new LatLng(-24.1923,-65.3026))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("carteleria"));
		  
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1920, -65.2945))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1975, -65.2912))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(24.1959, -65.2958))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2038, -65.2958))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1888, -65.3026))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1888, -65.3026))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2098, -65.2888)) 
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2061, -65.2852))
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet("circuito 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1764, -65.2983)) 
	        .title("REFERENTE SANCHEZ JOSE LUIS")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sanchez))
	        .snippet(" circuito 14"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2014, -65.2846))
	        .title("REFERENTE BURGOS MIRIAM")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 9"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1859,  -65.2938))
	        .title("REFERENTE BURGOS MIRIAM")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1923,  -65.2910)) 
	        .title("REFERENTE BURGOS MIRIAM")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 8"));
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1923,  -65.2910)) 
	        .title("REFERENTE BURGOS MIRIAM")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 9"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2131, -65.2668))
	        .title("REFERENTE BURGOS MIRIAM")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10A"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2107,  -65.2600))
	        .title("REFERENTE BURGOS MIRIAM")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10A"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2335,  -65.2753))
	        .title("REFERENTE FLORES ESTELA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10B"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2348,  -65.2635)) 
	        .title("REFERENTE FLORES ESTELA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10B"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2344,  -65.2549))
	        .title("REFERENTE FLORES ESTELA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10B"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2380,  -65.2498)) 
	        .title("REFERENTE FLORES ESTELA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10B"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1934,  -65.2900))
	        .title("REFERENTE LUCAS YOLANDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 9"));
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1854,  -65.3030))
	        .title("REFERENTE LUCAS YOLANDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1987,-65.2864))
	        .title("REFERENTE LUCAS YOLANDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 9"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1988,-65.2800))
	        .title("REFERENTE LUCAS YOLANDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 9"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1827,-65.3150)) 
	        .title("REFERENTE CACHO BRASICH")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO "));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2108,-65.2897))
	        .title("REFERENTE CACHO BRASICH")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 8 "));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2042606,-65.2698202))
	        .title("REFERENTE CACHO BRASICH")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10A "));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1830,-65.3014))
	        .title("REFERENTE FLORES CRISTINA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1 "));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1954,-65.3022))
	        .title("REFERENTE FLORES CRISTINA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 7 "));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1820,-65.3085)) 
	        .title("GARNICA GABRIEL")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1 "));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.2013,-65.3055))
	        .title("REFERENTE FLORES CRISTINA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 7 "));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1781,-65.3074))
	        .title("GARNICA GABRIEL")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 4 "));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1800, -65.3156))
	        .title("GARNICA GABRIEL")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1855, -65.3061))
	        .title("IBAÑES TERESA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1939, -65.3007)) 
	        .title("IBAÑES TERESA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1838, -65.2991)) 
	        .title("MAMANO RAUL")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_raul))
	        .snippet("CIRCUITO 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1855, -65.2995))
	        .title("MAMANO RAUL") 
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_raul))
	        .snippet("CIRCUITO 1"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1855,  -65.3041))
	        .title("MAMANO RAUL") 
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_raul))
	        .snippet("CIRCUITO 1")); 
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1961, -65.3023))  
	        .title("CRUZ YOLANDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 7"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2011, -65.3020))
	        .title("CRUZ YOLANDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 7"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1888, -65.3027))
	        .title("LUNA VICTORIA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_luna))
	        .snippet("CIRCUITO 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.1854, -65.3035))
	        .title("LUNA VICTORIA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_luna))
	        .snippet("CIRCUITO 1"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2117, -65.2682))
	        .title("RAMOS MONICA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10A"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.1837, -65.3057))
	        .title("RAMOS MONICA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.1925, -65.2907))
	        .title("CHOUQUE IVAN")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_ruso))
	        .snippet("CIRCUITO 9"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.1953, -65.2875))
	        .title("MARIA GALAN")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 9"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.1953, -65.2875))
	        .title("MARIA GALAN")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 9"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2032, -65.2775))
	        .title("MARIA GALAN")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10a"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(  -24.1862,-65.2936)) 
	        .title("AMELIA SUAREZ")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(  -24.1762,-65.2985))
	        .title("YOLANDA SURUGUAY")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 14"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(  -24.1827,-65.3017))
	        .title("HUMACATA MIRTA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 1"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(  -24.1935, -65.2861)) 
	        .title("PELOC JUANA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO :...."));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(  -24.2043, -65.2953))
	        .title("ITURBE NOEMI")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 8"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(  -24.1921, -65.2941)) 
	        .title("MAIZARES ELSA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2119,-65.268)) 
	        .title("NEIROT YOLANDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 10A"));
	        
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2012,-65.3019))
	        .title("GASPAR OLGA PATRICIA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 7"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2012,-65.3019))
	        .title("GASPAR OLGA PATRICIA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 7"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2012,-65.3019))
	        .title("LISANDRO AGUIAR")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_lisandro))
	        .snippet("CIRCUITO 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2024,-65.2971))
	        .title("VELIZ NILDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sinlogos))
	        .snippet("CIRCUITO 8"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2367,-65.2752))
	        .title("VILLALPANDO AIDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_villa))
	        .snippet("CIRCUITO 10B"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2441,-65.2621)) 
	        .title("VILLALPANDO AIDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_villa))
	        .snippet("CIRCUITO 10B"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng( -24.2482,-65.2759)) 
	        .title("VILLALPANDO AIDA")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_villa))
	        .snippet("CIRCUITO 10B"));
	        
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.250768, -65.1916634)) 
	        .title("BUNKER MARIO FIAD")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mario))
	        .snippet("MARIO FIAD"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.250768,-65.1916634))
	        .title("DIRIGENTE DE MARIO FIAF")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mario))
	        .snippet("NOMBRE DE EJEMPLO"));
	        
	        mapa.addMarker(new MarkerOptions()
	        .position(new LatLng(-24.386101,-65.255145))
	        .title("EJEMPLO MUNICIPIO DE JUJUY ")
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_muni))
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
