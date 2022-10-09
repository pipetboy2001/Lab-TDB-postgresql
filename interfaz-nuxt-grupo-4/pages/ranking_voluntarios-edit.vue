<template>
  <div class="container" style="width:700px;">
    <h1>EDITAR DATOS</h1>
    <form>



      <div class="form-group">
        <label for="nombre">Id Emergencia</label>
        <input type="text" class="form-control" minlength="3" maxlength="100" id="id_emergencia" v-model="form.id_emergencia" required>
        <small id="id_emergencia" class="form-text text-muted">Ingrese el id de la Emergencia a cambiar.</small>
      </div>


      <div class="form-group">
        <label for="descripcion">Tarea</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="tarea" v-model="form.tarea" required>
        <small id="tarea" class="form-text text-muted">Ingrese la tarea a cambiar.</small>
      </div>

      <div class="form-group">
        <label for="descripcion">Cant Volumen Requerida</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="cant_vol_req" v-model="form.cant_vol_req" required>
        <small id="cant_vol_req" class="form-text text-muted">Ingrese nuevo volumen a cambiar.</small>
      </div>


      <div class="form-group">
        <label for="descripcion">Id Volumen</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="id_vol" v-model="form.id_vol" required>
        <small id="id_vol" class="form-text text-muted">Ingrese nuevo id de volumen.</small>
      </div>


      <div class="form-group">
        <label for="descripcion">Puntaje</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="puntaje" v-model="form.puntaje" required>
        <small id="puntaje" class="form-text text-muted">Ingrese nuevo puntaje.</small>
      </div>



      <button type="submit" class="btn btn-primary" v-on:click="editar()">EDITAR</button>
      <button type="submit" class="btn btn-dark" v-on:click="cancelar()">CANCELAR</button>
    </form>
  </div>

</template>

<script>

//  import router from '@/router'
import axios from 'axios'

export default {
  name: 'EDITAR',
  data: function () {
    return {
      RANKING_VOLUNTARIOS_ID: '',
      form: {
        id: null,
        id_emergencia: '',
        tarea: '',
        cant_vol_req: '',
        id_vol: '',
        puntaje: ''
      }
    }
  },
  methods: {
    editar () {
      console.log(this.form)
      this.id = this.RANKING_VOLUNTARIOS_ID
      axios.put('http://localhost:3000/ranking_voluntariados', this.form)
      this.$router.push('/ranking_voluntariados')
    },
    cancelar () {
      this.$router.push('/ranking_voluntariados')
    }
  },
  mounted: function () {
    this.RANKING_VOLUNTARIOS_ID = this.$route.query.id
    const endpointRankingVoluntarios = 'http://localhost:3000/ranking_voluntariados/' + this.RANKING_VOLUNTARIOS_ID
    axios.get(endpointRankingVoluntarios).then(
      response => {
        this.form.id = this.RANKING_VOLUNTARIOS_ID
        this.form.id_emergencia = response.data.id_emergencia
        this.form.tarea = response.data.tarea
        this.form.cant_vol_req = response.data.cant_vol_req
        this.form.id_vol = response.data.id_vol
        this.form.puntaje = response.data.puntaje
        console.log(this.form)
      }
    )
  }
}
</script>
<style>

</style>
