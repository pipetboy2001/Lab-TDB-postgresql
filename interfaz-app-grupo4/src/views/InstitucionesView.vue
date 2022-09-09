<template>
  <div class="container">
    <h1>Instituciones CRUD</h1>
    <button type="button" class="btn btn-primary" v-on:click="nuevaInstitucion()">Añadir</button>
    <!--Bootstrp table-->
    <table class="table table-striped table-dark table-bordered table-secondary">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">NOMBRE</th>
          <th scope="col">DESCRIPCION</th>
          <th scope="col">ACCIONES</th>
        </tr>
      </thead>
      <tbody>
        <tr scope="row" v-for="institucion in todos" :key="institucion.id">
          <td>{{ institucion.id }}</td>
          <td>{{ institucion.nombre }}</td>
          <td>{{ institucion.descrip }}</td>
          <td>
            <!--Botones-->
            <button v-on:click="editar(institucion.id)" type="button" class="btn btn-warning">Editar</button>
            <button type="button" class="btn btn-danger">Borrar</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      todos: null
    }
  },
  mounted () {
    this.getTodos()
  },
  methods: {
    getTodos () {
      console.log('hola desde metro')
      axios.get('http://localhost:3000/instituciones')
        .then(response => {
          console.log(response.data)
          this.todos = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
    },
    editar (id) {
      this.$router.push('/instituciones-editar/' + id)
    }
  }

}
</script>
