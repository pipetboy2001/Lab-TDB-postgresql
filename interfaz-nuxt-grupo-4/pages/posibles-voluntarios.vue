<script>
location.reload()
</script>
<template>
  <div class="container">
    <h1>RANKING DE POSIBLES VOLUNTARIOS PARA EMERGENCIA</h1>
    <div>
      ---
    </div>
    <!--Bootstrp table-->
    <table class="table table-hover table-striped table-dark table-bordered table-secondary">
      <thead>
      <tr>
        <!--[ID-Emergencia - tarea - cant_vol_req - id_vol - puntaje]-->
        <th scope="col">ID VOLUNTARIO</th>
        <th scope="col">NOMBRE</th>
        <th scope="col">REQUERIMIENTOS CUMPLIDOS</th>
      </tr>
      </thead>
      <tbody>
      <tr scope="row" v-for="voluntario in pagina" :key="voluntario.id">
        <td>{{ voluntario.id_voluntario}}</td>
        <td>{{ voluntario.nombre}}</td>
        <td>{{ voluntario.req_cumplidos }}</td>
      </tr>
      </tbody>
    </table>
    <div></div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'posibles_voluntarios',
  data () {
    return {
      pagina: 1
    }
  },
  mounted: function () {
    this.emergenciaId = this.$route.query.id
    const url = 'http://localhost:3000/ranking-emergencias/' + this.emergenciaId
    axios.get(url).then(data => {
      this.pagina = data.data
    })
  }
}
</script>
