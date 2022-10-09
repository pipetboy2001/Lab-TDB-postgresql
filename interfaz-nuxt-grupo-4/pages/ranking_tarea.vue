<script>
location.reload()
</script>
<template>
    <div class="container">
        <h1>RANKING DE VOLUNTARIOS PARA TAREA</h1>
        <div>
            ---
        </div>
        <!--Bootstrp table-->
        <table class="table table-hover table-striped table-dark table-bordered table-secondary">
            <thead>
                <tr>
                    <!--[ID-Emergencia - tarea - cant_vol_req - id_vol - puntaje]-->
                    <th scope="col">EMERGENCIA</th>
                    <th scope="col">ID TAREA</th>
                    <th scope="col">TAREA</th>
                    <th scope="col">CANTIDAD VOLUNTARIO REQUERIDA</th>
                    <th scope="col">ID VOLUNTARIO</th>
                    <th scope="col">PUNTAJE</th>
                </tr>
            </thead>
            <tbody>
                <tr scope="row" v-for="listaRanking in pagina" :key="listaRanking.id">
                  <td>{{ listaRanking.emergencia}}</td>
                    <td>{{ listaRanking.id_tarea}}</td>
                    <td>{{ listaRanking.nombre_tarea }}</td>
                    <td>{{ listaRanking.cant_vol_requeridos }}</td>
                    <td>{{ listaRanking.id_voluntario }}</td>
                    <td>{{ listaRanking.puntaje }}</td>
                </tr>
            </tbody>
        </table>
        <div></div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ranking_tarea',
  data () {
    return {
      listaRanking: [],
      pagina: 1
    }
  },
  mounted: function () {
    this.institucionId = this.$route.query.id
    if (this.institucionId){
      const url = 'http://localhost:3000/ranking-tareas/' + this.institucionId
      axios.get(url).then(data => {
        this.pagina = data.data
      })
    }else{
      const url = 'http://localhost:3000/ranking-tareas/'
      axios.get(url).then(data => {
        this.pagina = data.data
      })
    }

  }
}
</script>
