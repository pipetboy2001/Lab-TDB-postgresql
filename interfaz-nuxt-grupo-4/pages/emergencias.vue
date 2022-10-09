<script>
location.reload()
</script>
<template>
  <div class="container">
    <h1>EMERGENCIAS</h1>
    <div>
      ---
    </div>
    <!--Bootstrp table-->
    <table class="table table-hover table-striped table-dark table-bordered table-secondary">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">NOMBRE</th>
        <th scope="col">DESCRIPCION</th>
        <th scope="col">FECHA INICIO</th>
        <th scope="col">FECHA FIN</th>
        <th scope="col">ID INSTITUCIÓN</th>
      </tr>
      </thead>
      <tbody>
      <tr scope="row" v-for="emergencia in pagina" :key="emergencia.id">
        <td>{{ emergencia.id }}</td>
        <td>{{ emergencia.nombre }}</td>
        <td>{{ emergencia.descrip }}</td>
        <td>{{ emergencia.finicio }}</td>
        <td>{{ emergencia.ffin }}</td>
        <td>{{ emergencia.id_institucion }}</td>
        <td>
          <!--Botones-->
          <button v-on:click="rankvoluntarios(emergencia.id)" type="button " class="btn btn-warning ">POSIBLES VOLUNTARIOS</button>
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
  name: 'emergenciasView',
  data () {
    return {
      listaInstituciones: [],
      pagina: 1
    }
  },
  methods: {
    rankvoluntarios (id) {
      this.$router.push('/posibles-voluntarios?id=' + id)
    },
    borrarTodos () {
      axios.delete('http://localhost:3000/emergencia')
        .then(datos => {
          console.log(datos)
          alert('Instituciones eliminadas con exito')
          location.reload()
        }).catch(error => {
        console.log(error)
        this.makeToast('Error', 'No se pudo agregar la institucion', 'error')
      })
    }

  },
  mounted: function () {
    const url = 'http://localhost:3000/emergencia' + this.listaInstituciones
    axios.get(url).then(data => {
      this.pagina = data.data
    })
  }
}
</script>
