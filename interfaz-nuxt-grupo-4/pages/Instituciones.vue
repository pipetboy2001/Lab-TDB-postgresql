<script>
location.reload()
</script>
<template>
  <div class="container">
    <h1>Instituciones CRUD</h1>
    <button type="button" class="btn btn-primary" v-on:click="añadir()">Añadir</button>
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
          <th scope="col">ACCIONES</th>
        </tr>
      </thead>
      <tbody>
        <tr scope="row" v-for="institucion in pagina" :key="institucion.id">
          <td>{{ institucion.id }}</td>
          <td>{{ institucion.nombre }}</td>
          <td>{{ institucion.descrip }}</td>
          <td>
            <!--Botones-->
            <button v-on:click="editar(institucion.id)" type="button" class="btn btn-warning ">Editar</button>
            <button v-on:click="borrar(institucion.id)" type="button " class="btn btn-danger ">Borrar</button>
          </td>
        </tr>
      </tbody>
    </table>
    <div></div>
    <button type="button" class="btn btn-danger" v-on:click="borrarTodos()">Eliminar todos</button>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'institucionesView',
  data () {
    return {
      pagina: null
    }
  },
  methods: {
    editar (id) {
      this.$router.push('/instituciones-edit?id=' + id)
    },
    borrar (id) {
      this.$router.push('/instituciones-delete?id=' + id)
    },
    añadir () {
      this.$router.push('/instituciones-create')
    },
    borrarTodos () {
      axios.delete('http://localhost:3000/instituciones')
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
    const url = 'http://localhost:3000/instituciones'
    axios.get(url).then(data => {
      this.pagina = data.data
    })
  }
}
</script>
