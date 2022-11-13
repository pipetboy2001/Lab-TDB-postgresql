<template>
  <body >
  <!-- container for tareas and regiones-->
  <div class="container">
    <!-- tareas -->
    <div class = "row">
      <div class = "col-sm">
        <h1 class="text-center">Tareas Regionales</h1>
        <br>
        <li v-for="tareas in tareas">
          Nombre: {{tareas.nombre  }}
          <br>
          Id: {{ tareas.id }}
          <br>
          Id Emergencia: {{ tareas.id_emergencia }}
          <br>
          Voluntarios Requeridos: {{ tareas.cant_vol_requeridos }}
          <br>
          <button class="btn btn-primary" v-on:click="getPoint(tareas.geom)">Ver en el mapa</button>
          <br>
          <br>
        </li>


        <button class="btn btn-primary" v-on:click="toIndex()" style="position:absolute; left: 0;bottom: 0;" >Volver al inicio</button>
      </div>
      <!-- regiones -->
      <div class = "col-sm">
        <label for="regiones">Seleccione una región: </label>
        <select v-model="regionSelect">
          <option disabled value="">Seleccione una región</option>
          <option v-for="(region, key) in regiones" :key="region.id" :value="region.gid">{{region.nom_reg}}</option>
        </select>
        <button type="button" class="btn btn-primary" v-on:click="getTareaByIdRegion()">Buscar</button>
        <div id = "map">
          <l-map :zoom="zoom" :center="center">
            <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
            <l-marker :lat-lng="markerLatLng"></l-marker>
          </l-map>
        </div>
      </div>

    </div>

  </div>
  </body>
</template>

<style>
  #map {
    height: 95vh;
    width: 95vh;
  }
</style>

<script>
import {LMap, LTileLayer, LMarker} from 'vue2-leaflet';
import axios from "axios";



var latitud= -33.456;
var longitude= -70.648;
export default {
  components: {
    LMap,
    LTileLayer,
    LMarker
  },
  data () {
    return {
      url: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      attribution:
        '&copy; <a target="_blank" href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      zoom: 9,
      center: [-33.456, -70.648],
      map: null,
      dragable: true,
      title: 'Marker',
      markerLatLng: [latitud, longitude],
      regiones: [],
      tareas:[],
      regionSelect: '',
    }
  },
  methods: {
    toIndex(){
      this.$router.push('/');
    },
    getPoint: function (geom) {
      //"POINT(-70.682816 -33.44947)"
      var point = geom.split("POINT(")[1].split(")")[0].split(" ");
      this.seeInTheMap(point[1], point[0]);
    },
     seeInTheMap: function (latitud, longitude) {
      this.markerLatLng = [latitud, longitude];
     },

    async getTareaByIdRegion() {
      try {
        let response = await axios.get('http://localhost:3000/tarea/region/'+this.regionSelect);
        this.tareas = response.data;
        console.log(response.data);
      } catch (error) {
        console.log('error', error);
      }
      console.log(this.tareas+"<- this tareas");
    },

    async getRegiones() {
      try {
        let response = await axios.get('http://localhost:3000/region');
        this.regiones = response.data;
        console.log(response.data);
      } catch (error) {
        console.log('error', error);
      }
    },
  },
  mounted: function () {
    this.$nextTick(function () {
      this.getRegiones();
    })
  }
}
</script>

<style>

</style>
