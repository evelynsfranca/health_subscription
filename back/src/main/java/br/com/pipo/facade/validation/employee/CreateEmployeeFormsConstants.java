package br.com.pipo.facade.validation.employee;

import br.com.pipo.facade.dto.employee.EmployeeToCreateDTO;
import br.com.pipo.model.enumeration.PartnerName;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Predicate;

public enum CreateEmployeeFormsConstants {

    CPF_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNotBlank(it.getCpf());
        }

        @Override
        public String getMessage() {
            return "Cpf vazio";
        }

        @Override
        public String getType(String name) {
            return "GERAL";
        }
    },

    CLIENT_REQUIRED {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> Objects.nonNull(it.getClient()) && StringUtils.isNotBlank(it.getClient().getId());
        }

        @Override
        public String getMessage() {
            return "Campo Cliente vazio";
        }

        @Override
        public String getType(String name) {
            return "GERAL";
        }
    },

    PRODUCT_REQUIRED {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> Objects.nonNull(it.getProducts())
                    && it.getProducts().size() > 0
                    && it.getProducts().stream().allMatch(product -> StringUtils.isNotBlank(product.getId()));
        }

        @Override
        public String getMessage() {
            return "Campo Produto vazio";
        }

        @Override
        public String getType(String name) {
            return "GERAL";
        }
    },

    ADDRESS_REQUIRED {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> Objects.nonNull(it.getAddress());
        }

        @Override
        public String getMessage() {
            return "Campos do endereço vazios";
        }

        @Override
        public String getType(String name) {
            return PartnerName.PAMPULHA_INTRAMEDICA.name();
        }
    },


    NAME_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNoneBlank(it.getName());
        }

        @Override
        public String getMessage() {
            return "Campo Nome vazio";
        }

        @Override
        public String getType(String name) {
            if (Objects.equals(name, PartnerName.DENTAL_SORRISO.name())
                || Objects.equals(name, PartnerName.PAMPULHA_INTRAMEDICA.name())
                || Objects.equals(name, PartnerName.NORTE_EUROPA.name())
            ) {
                return PartnerName.valueOf(name).name();
            }
            return "";
        }
    },

    ADMISSION_DATE_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> it.getAdmissionDate() != null;
        }

        @Override
        public String getMessage() {
            return "Campo Data de admissão vazio";
        }

        @Override
        public String getType(String name) {
            if (Objects.equals(name, PartnerName.PAMPULHA_INTRAMEDICA.name())
                    || Objects.equals(name, PartnerName.NORTE_EUROPA.name())
            ) {
                return PartnerName.valueOf(name).name();
            }
            return "";
        }
    },

//    Dental Sorriso

    WEIGHT_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNoneBlank(it.getWeight());
        }

        @Override
        public String getMessage() {
            return "Campo Peso vazio";
        }

        @Override
        public String getType(String name) {
            return PartnerName.DENTAL_SORRISO.name();
        }
    },

    HEIGHT_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNoneBlank(it.getHeight());
        }

        @Override
        public String getMessage() {
            return "Campo Altura vazio";
        }

        @Override
        public String getType(String name) {
            return PartnerName.DENTAL_SORRISO.name();
        }
    },

    //    Mente Sa, Corpo São

    MEDITATION_HOURS_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> Objects.nonNull(it.getMeditationHours());
        }

        @Override
        public String getMessage() {
            return "Horas meditadas vazio";
        }

        @Override
        public String getType(String name) {
            return PartnerName.MENTE_SA_CORPO_SAO.name();
        }
    },

    //    Norte Europa

    EMAIL_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNotBlank(it.getEmail());
        }

        @Override
        public String getMessage() {
            return "Campo Email vazio";
        }

        @Override
        public String getType(String name) {
            return PartnerName.NORTE_EUROPA.name();
        }
    },

//    Pampula Intramédiica

    ADDRESS_STREET_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNotBlank(it.getAddress().getStreet());
        }

        @Override
        public String getMessage() {
            return "Campo Rua vazia";
        }

        @Override
        public String getType(String name) {
            return PartnerName.PAMPULHA_INTRAMEDICA.name();
        }
    },

    ADDRESS_NUMBER_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNoneBlank(it.getAddress().getNumber());
        }

        @Override
        public String getMessage() {
            return "Campo Número vazio";
        }

        @Override
        public String getType(String name) {
            return PartnerName.PAMPULHA_INTRAMEDICA.name();
        }
    },

    ADDRESS_NEIGHBORHOOD_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNoneBlank(it.getAddress().getNeighborhood());
        }

        @Override
        public String getMessage() {
            return "Campo Bairro vazio";
        }

        @Override
        public String getType(String name) {
            return PartnerName.PAMPULHA_INTRAMEDICA.name();
        }
    },

    ADDRESS_CITY_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNoneBlank(it.getAddress().getCity());
        }

        @Override
        public String getMessage() {
            return "Campo Cidade vazia";
        }

        @Override
        public String getType(String name) {
            return PartnerName.PAMPULHA_INTRAMEDICA.name();
        }
    },

    ADDRESS_STATE_NOT_BLANK {
        @Override
        public Predicate<EmployeeToCreateDTO> getPredicate() {
            return it -> StringUtils.isNoneBlank(it.getAddress().getState());
        }

        @Override
        public String getMessage() {
            return "Campo Estado vazio";
        }

        @Override
        public String getType(String name) {
            return PartnerName.PAMPULHA_INTRAMEDICA.name();
        }
    }
    ;

    public abstract Predicate<EmployeeToCreateDTO> getPredicate();

    public abstract String getMessage();

    public abstract String getType(String name);

}
