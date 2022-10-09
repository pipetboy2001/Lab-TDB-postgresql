<script>
location.reload()
</script>
<template>
    <div class="container">
        <h1>Ranking Para Voluntario</h1>
        <div>
            ---
        </div>
        <!--Bootstrp table-->
        <table class="table table-hover table-striped table-dark table-bordered table-secondary">
            <thead>
                <tr>
                    <!--[ID-Emergencia - tarea - cant_vol_req - id_vol - puntaje]-->
                    <th scope="col">ID</th>
                    <th scope="col">EMERGENCIA</th>
                    <th scope="col">TAREA</th>
                    <th scope="col">CANTIDAD VOLUMEN REQUERIDA</th>
                    <th scope="col">ID VOLUMEN</th>
                    <th scope="col">PUNTAJE</th>
                </tr>
            </thead>
            <tbody>
                <tr scope="row" v-for="ranking_voluntarios in pagina" :key="ranking_voluntarios.id">
                    <td>{{ ranking_voluntarios.id }}</td>
                    <td>{{ ranking_voluntarios.id_emergencia}}</td>
                    <td>{{ ranking_voluntarios.tarea }}</td>
                    <td>{{ ranking_voluntarios.cant_vol_req }}</td>
                    <td>{{ ranking_voluntarios.id_vol }}</td>
                    <td>{{ ranking_voluntarios.puntaje }}</td>
                </tr>
            </tbody>
        </table>
        <div></div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ranking_voluntariadosView',
  data () {
    return {
      listaranking_voluntariados: [],
      pagina: 1
    }
  },
  methods: {
    editar (id) {
      this.$router.push('/ranking_voluntariados-edit?id=' +id)
    },
    borrar (id) {
      this.$router.push('/ranking_voluntariados-delete?id=' + id)
    },
    crear (){
      this.$router.push('/ranking_voluntariados-create')
    }
  },
  mounted: function () {
    const url = 'http://localhost:3000/ranking_voluntariados' + this.listaranking_voluntariados
    axios.get(url).then(data => {
      this.pagina = data.data
    })
  }
}
</script>
