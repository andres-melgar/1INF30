using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.Model
{
    public class TiposDocumentosDTO
    {
        private int? tipoDocumentoId;
        private string nombre;

        public TiposDocumentosDTO()
        {
            this.TipoDocumentoId = null;
            this.Nombre = null;
        }

        public TiposDocumentosDTO(int tipoDocumentoId, string nombre)
        {
            this.TipoDocumentoId = tipoDocumentoId;
            this.Nombre = nombre;
        }

        public int? TipoDocumentoId { get => tipoDocumentoId; set => tipoDocumentoId = value; }
        public string Nombre { get => nombre; set => nombre = value; }
    }
}
