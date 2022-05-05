/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package cloud.csonic.types.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TransactionEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5525136904267062587L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TransactionEvent\",\"namespace\":\"cloud.csonic.types.avro\",\"fields\":[{\"name\":\"OriginId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"DestinationId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"Amount\",\"type\":[\"null\",\"double\"]},{\"name\":\"Created\",\"type\":[\"null\",{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}]},{\"name\":\"TransactionId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<TransactionEvent> ENCODER =
      new BinaryMessageEncoder<TransactionEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TransactionEvent> DECODER =
      new BinaryMessageDecoder<TransactionEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TransactionEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TransactionEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TransactionEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TransactionEvent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TransactionEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TransactionEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TransactionEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TransactionEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String OriginId;
  private java.lang.String DestinationId;
  private java.lang.Double Amount;
  private java.time.Instant Created;
  private java.lang.String TransactionId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TransactionEvent() {}

  /**
   * All-args constructor.
   * @param OriginId The new value for OriginId
   * @param DestinationId The new value for DestinationId
   * @param Amount The new value for Amount
   * @param Created The new value for Created
   * @param TransactionId The new value for TransactionId
   */
  public TransactionEvent(java.lang.String OriginId, java.lang.String DestinationId, java.lang.Double Amount, java.time.Instant Created, java.lang.String TransactionId) {
    this.OriginId = OriginId;
    this.DestinationId = DestinationId;
    this.Amount = Amount;
    this.Created = Created;
    this.TransactionId = TransactionId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return OriginId;
    case 1: return DestinationId;
    case 2: return Amount;
    case 3: return Created;
    case 4: return TransactionId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: OriginId = value$ != null ? value$.toString() : null; break;
    case 1: DestinationId = value$ != null ? value$.toString() : null; break;
    case 2: Amount = (java.lang.Double)value$; break;
    case 3: Created = (java.time.Instant)value$; break;
    case 4: TransactionId = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'OriginId' field.
   * @return The value of the 'OriginId' field.
   */
  public java.lang.String getOriginId() {
    return OriginId;
  }


  /**
   * Sets the value of the 'OriginId' field.
   * @param value the value to set.
   */
  public void setOriginId(java.lang.String value) {
    this.OriginId = value;
  }

  /**
   * Gets the value of the 'DestinationId' field.
   * @return The value of the 'DestinationId' field.
   */
  public java.lang.String getDestinationId() {
    return DestinationId;
  }


  /**
   * Sets the value of the 'DestinationId' field.
   * @param value the value to set.
   */
  public void setDestinationId(java.lang.String value) {
    this.DestinationId = value;
  }

  /**
   * Gets the value of the 'Amount' field.
   * @return The value of the 'Amount' field.
   */
  public java.lang.Double getAmount() {
    return Amount;
  }


  /**
   * Sets the value of the 'Amount' field.
   * @param value the value to set.
   */
  public void setAmount(java.lang.Double value) {
    this.Amount = value;
  }

  /**
   * Gets the value of the 'Created' field.
   * @return The value of the 'Created' field.
   */
  public java.time.Instant getCreated() {
    return Created;
  }


  /**
   * Sets the value of the 'Created' field.
   * @param value the value to set.
   */
  public void setCreated(java.time.Instant value) {
    this.Created = value;
  }

  /**
   * Gets the value of the 'TransactionId' field.
   * @return The value of the 'TransactionId' field.
   */
  public java.lang.String getTransactionId() {
    return TransactionId;
  }


  /**
   * Sets the value of the 'TransactionId' field.
   * @param value the value to set.
   */
  public void setTransactionId(java.lang.String value) {
    this.TransactionId = value;
  }

  /**
   * Creates a new TransactionEvent RecordBuilder.
   * @return A new TransactionEvent RecordBuilder
   */
  public static cloud.csonic.types.avro.TransactionEvent.Builder newBuilder() {
    return new cloud.csonic.types.avro.TransactionEvent.Builder();
  }

  /**
   * Creates a new TransactionEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TransactionEvent RecordBuilder
   */
  public static cloud.csonic.types.avro.TransactionEvent.Builder newBuilder(cloud.csonic.types.avro.TransactionEvent.Builder other) {
    if (other == null) {
      return new cloud.csonic.types.avro.TransactionEvent.Builder();
    } else {
      return new cloud.csonic.types.avro.TransactionEvent.Builder(other);
    }
  }

  /**
   * Creates a new TransactionEvent RecordBuilder by copying an existing TransactionEvent instance.
   * @param other The existing instance to copy.
   * @return A new TransactionEvent RecordBuilder
   */
  public static cloud.csonic.types.avro.TransactionEvent.Builder newBuilder(cloud.csonic.types.avro.TransactionEvent other) {
    if (other == null) {
      return new cloud.csonic.types.avro.TransactionEvent.Builder();
    } else {
      return new cloud.csonic.types.avro.TransactionEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for TransactionEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TransactionEvent>
    implements org.apache.avro.data.RecordBuilder<TransactionEvent> {

    private java.lang.String OriginId;
    private java.lang.String DestinationId;
    private java.lang.Double Amount;
    private java.time.Instant Created;
    private java.lang.String TransactionId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(cloud.csonic.types.avro.TransactionEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.OriginId)) {
        this.OriginId = data().deepCopy(fields()[0].schema(), other.OriginId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.DestinationId)) {
        this.DestinationId = data().deepCopy(fields()[1].schema(), other.DestinationId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.Amount)) {
        this.Amount = data().deepCopy(fields()[2].schema(), other.Amount);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.Created)) {
        this.Created = data().deepCopy(fields()[3].schema(), other.Created);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.TransactionId)) {
        this.TransactionId = data().deepCopy(fields()[4].schema(), other.TransactionId);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing TransactionEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(cloud.csonic.types.avro.TransactionEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.OriginId)) {
        this.OriginId = data().deepCopy(fields()[0].schema(), other.OriginId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.DestinationId)) {
        this.DestinationId = data().deepCopy(fields()[1].schema(), other.DestinationId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Amount)) {
        this.Amount = data().deepCopy(fields()[2].schema(), other.Amount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.Created)) {
        this.Created = data().deepCopy(fields()[3].schema(), other.Created);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.TransactionId)) {
        this.TransactionId = data().deepCopy(fields()[4].schema(), other.TransactionId);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'OriginId' field.
      * @return The value.
      */
    public java.lang.String getOriginId() {
      return OriginId;
    }


    /**
      * Sets the value of the 'OriginId' field.
      * @param value The value of 'OriginId'.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder setOriginId(java.lang.String value) {
      validate(fields()[0], value);
      this.OriginId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'OriginId' field has been set.
      * @return True if the 'OriginId' field has been set, false otherwise.
      */
    public boolean hasOriginId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'OriginId' field.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder clearOriginId() {
      OriginId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'DestinationId' field.
      * @return The value.
      */
    public java.lang.String getDestinationId() {
      return DestinationId;
    }


    /**
      * Sets the value of the 'DestinationId' field.
      * @param value The value of 'DestinationId'.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder setDestinationId(java.lang.String value) {
      validate(fields()[1], value);
      this.DestinationId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'DestinationId' field has been set.
      * @return True if the 'DestinationId' field has been set, false otherwise.
      */
    public boolean hasDestinationId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'DestinationId' field.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder clearDestinationId() {
      DestinationId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'Amount' field.
      * @return The value.
      */
    public java.lang.Double getAmount() {
      return Amount;
    }


    /**
      * Sets the value of the 'Amount' field.
      * @param value The value of 'Amount'.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder setAmount(java.lang.Double value) {
      validate(fields()[2], value);
      this.Amount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'Amount' field has been set.
      * @return True if the 'Amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'Amount' field.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder clearAmount() {
      Amount = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'Created' field.
      * @return The value.
      */
    public java.time.Instant getCreated() {
      return Created;
    }


    /**
      * Sets the value of the 'Created' field.
      * @param value The value of 'Created'.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder setCreated(java.time.Instant value) {
      validate(fields()[3], value);
      this.Created = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'Created' field has been set.
      * @return True if the 'Created' field has been set, false otherwise.
      */
    public boolean hasCreated() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'Created' field.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder clearCreated() {
      Created = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'TransactionId' field.
      * @return The value.
      */
    public java.lang.String getTransactionId() {
      return TransactionId;
    }


    /**
      * Sets the value of the 'TransactionId' field.
      * @param value The value of 'TransactionId'.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder setTransactionId(java.lang.String value) {
      validate(fields()[4], value);
      this.TransactionId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'TransactionId' field has been set.
      * @return True if the 'TransactionId' field has been set, false otherwise.
      */
    public boolean hasTransactionId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'TransactionId' field.
      * @return This builder.
      */
    public cloud.csonic.types.avro.TransactionEvent.Builder clearTransactionId() {
      TransactionId = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TransactionEvent build() {
      try {
        TransactionEvent record = new TransactionEvent();
        record.OriginId = fieldSetFlags()[0] ? this.OriginId : (java.lang.String) defaultValue(fields()[0]);
        record.DestinationId = fieldSetFlags()[1] ? this.DestinationId : (java.lang.String) defaultValue(fields()[1]);
        record.Amount = fieldSetFlags()[2] ? this.Amount : (java.lang.Double) defaultValue(fields()[2]);
        record.Created = fieldSetFlags()[3] ? this.Created : (java.time.Instant) defaultValue(fields()[3]);
        record.TransactionId = fieldSetFlags()[4] ? this.TransactionId : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TransactionEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<TransactionEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TransactionEvent>
    READER$ = (org.apache.avro.io.DatumReader<TransactionEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










