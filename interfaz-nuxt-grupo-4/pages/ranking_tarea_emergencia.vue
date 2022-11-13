<template>
  <body>

  <button id = "boton" v-on:click="toIndex()" type="button" class="btn btn-warning" >Volver a la pagina principal</button>
  <div class="container">
    <div class = "row">
      <div id="bordes">
        <table class="table table-hover table-striped table-dark table-bordered table-secondary">
          <thead>
          <tr>
            <th scope="col">Emergencias</th>
          </tr>
          </thead>
          <tbody>
          <tr scope="row" v-for="emergencia in pagina" :key="emergencia.id">
            <td>
              Id: {{ emergencia.id }}
              Emergencia: {{ emergencia.nombre }}
              <button v-on:click="verRanking(emergencia.id)" type="button" class="btn btn-warning ">Ver ranking</button>
            </td>
          </tr>
          </tbody>
        </table>

      </div>

      <div id="bordes">
        <table class="table table-hover table-striped table-dark table-bordered table-secondary" >
          <thead>
          <tr>
            <th scope="col">Ranking</th>
          </tr>
          </thead>
          <tbody>
          <tr scope="row" v-for="voluntario in ranking" :key="voluntario.id">
            <td>
              Rut: {{ voluntario.id_voluntaro}}
              Nombre: {{ voluntario.nombre }}
              Cantidad: {{ voluntario.cantidad }}
            </td>
          </tr>
          </tbody>

        </table>
      </div>


    </div>
  </div>

  </body>

</template>
<script>
import axios from "axios";
export default {
  name: "ranking_tarea_emergenciaView",
  data() {
    return {
      pagina: null,
      ranking: null
    };
  },
  methods: {
    toIndex(){
      this.$router.push('/');
    },
    async getVoluntarios(){
      const url = "http://localhost:3000/rankingbyview";
      const data = await axios.get(url);
      this.ranking = data.data;
    },

    async verRanking(id) {
      try{axios.post("http://localhost:3000/create/view/" + id).then(
        this.getVoluntarios()
      )
      }catch (e) {
        console.log("un error en la peticion...");
        console.log(e);
      }
    },
  },
  mounted() {
    axios
      .get("http://localhost:3000/emergencia")
      .then(response => (this.pagina = response.data));
  }
};


</script>
<style>
  #bordes {
    border: 1px solid black;
    margin: 10px;
    padding: 10px;
  }
  #boton{
    position:absolute;
    bottom:15px;
    right:15px;}


</style>
