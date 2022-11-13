<script>
location.reload()
</script>
<template>
  <div class="container">
    <h1>TAREAS</h1>
    <div>
      ---
    </div>
    <!--Bootstrp table-->
    <table class="table table-hover table-striped table-dark table-bordered table-secondary">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">NOMBRE</th>
        <th scope="col">ID EMERGENCIA</th>
        <th scope="col">VOLUNTARIOS REQUERIDOS</th>
      </tr>
      </thead>
      <tbody>
      <tr scope="row" v-for="tarea in pagina" :key="tarea.id">
        <td>{{ tarea.id }}</td>
        <td>{{ tarea.nombre }}</td>
        <td>{{ tarea.id_emergencia }}</td>
        <td>{{ tarea.cant_vol_requeridos }}</td>
        <td>
          <!--Botones-->
          <button v-on:click="rankvoluntarios(tarea.id)" type="button " class="btn btn-warning ">RANKING VOLUNTARIOS</button>
        </td>
      </tr>
      </tbody>
    </table>
    <div></div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'tareasView',
  data () {
    return {
      pagina: null
    }
  },
  methods: {
    rankvoluntarios (id) {
      this.$router.push('/ranking_tarea?id=' + id)
    },
  },
  mounted: function () {
    const url = 'http://localhost:3000/tarea'
    axios.get(url).then(data => {
      this.pagina = data.data
    })
  }
}
</script>
